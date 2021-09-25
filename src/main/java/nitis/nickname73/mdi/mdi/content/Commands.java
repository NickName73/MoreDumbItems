package nitis.nickname73.mdi.mdi.content;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.ArgumentTypes;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.NumberRangeArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.HungerConstants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import org.apache.commons.lang3.NotImplementedException;

public class Commands implements ModInitializer {
    public static final CommandException NOT_IMPLEMENT_ERROR = new CommandException(new TranslatableText("command.mdi.error.not_implement"));
    public static final CommandException ENTITY_NOT_PLAYER = new CommandException(new TranslatableText("command.mdi.error.not_player"));
    public static final CommandException OUT_OF_HUNGER = new CommandException(new TranslatableText("command.mdi.error.out_of_hunger"));

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            CommandNode hungerRoot = dispatcher.register(CommandManager.literal("hunger").then(CommandManager.argument("player",EntityArgumentType.player())
                    // /hunger @s
                    .then(CommandManager.literal("hunger")
                            // /hunger @s hunger [set|get]
                            .then(CommandManager.literal("set")
                                    .then(CommandManager.argument("amount", IntegerArgumentType.integer(0,999))
                                    .executes((context) ->{
                                        return setHunger(context.getArgument("player",EntitySelector.class),context.getArgument("amount", int.class),context.getSource());
                                    })))
                            .then(CommandManager.literal("get")
                                    .executes((context) -> {
                                        return getHunger(context.getArgument("player",EntitySelector.class), context.getSource());
                                    })
                                )
                        )
                    .then(CommandManager.literal("saturation")
                            // /hunger @s saturation [set|get]
                            .then(CommandManager.literal("set")
                                    .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0f,999f))
                                    .executes((context) ->{
                                        return  setSaturation(context.getArgument("player",EntitySelector.class),context.getArgument("amount", Float.class),context.getSource());
                                    })))
                            .then(CommandManager.literal("get")
                                    .executes((context) -> {
                                        return getSaturation(context.getArgument("player",EntitySelector.class),context.getSource());
                                    })
                                 )
                        )
                    ));
            CommandNode chatClearRoot = dispatcher.register(CommandManager.literal("chatclear").executes((context)->{
                return clearChat();
            }));
            CommandNode chatClearShortype = dispatcher.register(CommandManager.literal("cclr").executes((context)->{
                return clearChat();
            }));
        });
    }

    private int clearChat() {
        MinecraftClient.getInstance().inGameHud.clear();
        return 1;
    }

    public static int setHunger(EntitySelector entity,int amount, ServerCommandSource serverCommandSource){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        PlayerEntity player = getPlayerFromEntitySelector(entity,serverCommandSource);
        player.getHungerManager().setFoodLevel(amount);
        minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.set_hunger", amount), Util.NIL_UUID);
        return 1;
    }
    public static int getHunger(EntitySelector entity, ServerCommandSource serverCommandSource){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        PlayerEntity player = getPlayerFromEntitySelector(entity,serverCommandSource);
        float hunger = player.getHungerManager().getFoodLevel();
        minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.get_hunger",hunger), Util.NIL_UUID);
        return 1;
    }

    public static int setSaturation(EntitySelector entity,float amount, ServerCommandSource serverCommandSource){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        PlayerEntity player = getPlayerFromEntitySelector(entity,serverCommandSource);
        player.getHungerManager().setSaturationLevel(amount);
        minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.set_saturation", amount), Util.NIL_UUID);
        return 1;
    }
    public static int getSaturation(EntitySelector entity, ServerCommandSource serverCommandSource){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        PlayerEntity player = getPlayerFromEntitySelector(entity,serverCommandSource);
        float saturation = player.getHungerManager().getSaturationLevel();
        minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.get_saturation",saturation), Util.NIL_UUID);
        return 1;
    }





    public static PlayerEntity getPlayerFromEntitySelector(EntitySelector entitySelector, ServerCommandSource serverCommandSource){
        try {
            PlayerEntity player = (PlayerEntity)entitySelector.getEntity(serverCommandSource);
            return player;
        } catch (CommandSyntaxException e) {
            serverCommandSource.sendError(ENTITY_NOT_PLAYER.getTextMessage());
            return null;
        }
    }
}
