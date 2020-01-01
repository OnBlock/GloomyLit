package xyz.onblock.gloom.server;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.literal;

public class GloomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralCommandNode<ServerCommandSource> rootCommand = literal("gloom").build();

        LiteralArgumentBuilder<ServerCommandSource> helpArgument = literal("help");
        LiteralArgumentBuilder<ServerCommandSource> itemArgument = literal("item");
        LiteralArgumentBuilder<ServerCommandSource> guiArgument = literal("gui");

        rootCommand.addChild(helpArgument.build());
        rootCommand.addChild(itemArgument.build());
        rootCommand.addChild(guiArgument.build());
        dispatcher.getRoot().addChild(rootCommand);
    }


}
