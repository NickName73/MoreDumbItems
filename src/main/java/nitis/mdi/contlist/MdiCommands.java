package nitis.mdi.contlist;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.CommandNode;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntitySelector;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.GameRuleCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import nitis.mdi.MdiConfig;

public class MdiCommands implements ModInitializer {
    public static final CommandException NOT_IMPLEMENT_ERROR = new CommandException(Text.translatable("command.mdi.error.not_implement"));
    public static final CommandException ENTITY_NOT_PLAYER = new CommandException(Text.translatable("command.mdi.error.not_player"));
    public static final CommandException OUT_OF_HUNGER = new CommandException(Text.translatable("command.mdi.error.out_of_hunger"));

    @Override
    public void onInitialize() {
        /*
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
        */
    }
}