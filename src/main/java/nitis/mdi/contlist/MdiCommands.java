package nitis.mdi.contlist;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.GameRuleCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import nitis.mdi.MdiConfig;

public class MdiCommands implements ModInitializer {
    public static final CommandException NOT_IMPLEMENT_ERROR = new CommandException(new TranslatableText("command.mdi.error.not_implement"));
    public static final CommandException ENTITY_NOT_PLAYER = new CommandException(new TranslatableText("command.mdi.error.not_player"));
    public static final CommandException OUT_OF_HUNGER = new CommandException(new TranslatableText("command.mdi.error.out_of_hunger"));

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            if(MdiConfig.config.healthCommand){
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
            }
            if(MdiConfig.config.chatClearCommand){
                CommandNode chatClearRoot = dispatcher.register(CommandManager.literal("chatclear")
                        .executes((context)->{
                            return clearChat(context.getSource());
                        }));
                CommandNode chatClearShortType = dispatcher.register(CommandManager.literal("cclr")
                        .executes((context)->{
                            return clearChat(context.getSource());
                        }));
            }
            if(MdiConfig.config.healthCommand){
                CommandNode healthRoot = dispatcher.register(CommandManager.literal("health")
                        .then(CommandManager.argument("entity", EntityArgumentType.entity())
                                .then(CommandManager.literal("abosrb")
                                        .then(CommandManager.literal("set")
                                                .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                                                        .executes((context) -> {
                                                            return setAbsorbHealth(context.getArgument("entity", EntitySelector.class), context.getArgument("amount", float.class), context.getSource());
                                                        })))
                                        .then(CommandManager.literal("get")
                                                .executes((context) -> {
                                                    return getAbsorbHealth(context.getArgument("entity",EntitySelector.class), context.getSource());
                                                }))
                                ).then(CommandManager.literal("set")
                                        .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                                                .executes((context) -> {
                                                    return setHealth(context.getArgument("entity", EntitySelector.class), context.getArgument("amount", float.class), context.getSource());
                                                })))
                                .then(CommandManager.literal("get")
                                        .executes((context) -> {
                                            return getHealth(context.getArgument("entity",EntitySelector.class), context.getSource());
                                        }))
                        ));
            }
        });
    }
    private int getAbsorbHealth(EntitySelector entity, ServerCommandSource serverCommandSource){
        try{
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            LivingEntity livingEntity = (LivingEntity)entity.getEntity(serverCommandSource);
            float health = livingEntity.getAbsorptionAmount();
            minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.get_absorb", health), Util.NIL_UUID);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    private int setAbsorbHealth(EntitySelector entity, float amount, ServerCommandSource serverCommandSource){
        try{
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            LivingEntity livingEntity = (LivingEntity)entity.getEntity(serverCommandSource);
            if(livingEntity.getAbsorptionAmount() == amount) {
                return 2;
            }
            livingEntity.setAbsorptionAmount(amount);
            minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.set_absorb", livingEntity.getAbsorptionAmount()), Util.NIL_UUID);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    private int getHealth(EntitySelector entity, ServerCommandSource serverCommandSource){
        try{
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            LivingEntity livingEntity = (LivingEntity)entity.getEntity(serverCommandSource);
            float health = livingEntity.getHealth();
            minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.get_health", health), Util.NIL_UUID);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    private int setHealth(EntitySelector entity, float amount, ServerCommandSource serverCommandSource){
        try{
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            LivingEntity livingEntity = (LivingEntity)entity.getEntity(serverCommandSource);
            if(livingEntity.getHealth() == amount) {
                return 2;
            }
            livingEntity.setHealth(amount);
            minecraftClient.inGameHud.addChatMessage(MessageType.SYSTEM, new TranslatableText("command.mdi.set_health", livingEntity.getHealth()), Util.NIL_UUID);
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    private int clearChat(ServerCommandSource serverCommandSource) {
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