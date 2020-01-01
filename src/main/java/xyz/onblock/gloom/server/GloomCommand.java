package xyz.onblock.gloom.server;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.SharedConstants;
import net.minecraft.command.arguments.BlockPosArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.math.BlockPos;
import xyz.onblock.gloom.core.GloomCore;

import static net.minecraft.server.command.CommandManager.literal;

public class GloomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralCommandNode<ServerCommandSource> rootCommand = literal("gloom").build();

        LiteralArgumentBuilder<ServerCommandSource> helpArgument = literal("help");
        LiteralArgumentBuilder<ServerCommandSource> itemArgument = literal("item");
        LiteralArgumentBuilder<ServerCommandSource> guiArgument = literal("gui");
        LiteralArgumentBuilder<ServerCommandSource> testArgument = literal("test")
                .requires(src -> SharedConstants.isDevelopment)
                .then(CommandManager.argument("pos", BlockPosArgumentType.blockPos())
                        .then(CommandManager.argument("level", IntegerArgumentType.integer(0, 16)).executes(GloomCommand::test)));

        rootCommand.addChild(testArgument.build());
        rootCommand.addChild(helpArgument.build());
        rootCommand.addChild(itemArgument.build());
        rootCommand.addChild(guiArgument.build());
        dispatcher.getRoot().addChild(rootCommand);
    }

    private static int test(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        BlockPos pos = BlockPosArgumentType.getBlockPos(ctx, "pos");
        int level = IntegerArgumentType.getInteger(ctx, "level");
        ServerPlayerEntity player = ctx.getSource().getPlayer();

        GloomCore.setLight(ctx.getSource().getWorld(), pos, level, player.chunkX, player.chunkZ);
        ctx.getSource().sendFeedback(new LiteralText(String.format("Set light block (level: %s) at %s", level, pos.toString())), false);
        return 1;
    }

}
