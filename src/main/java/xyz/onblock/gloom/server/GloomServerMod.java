package xyz.onblock.gloom.server;

import net.minecraft.server.MinecraftServer;
import xyz.onblock.gloom.core.GloomCore;

public class GloomServerMod {
    public static void init(MinecraftServer server) {
        GloomCore core = new GloomCore(server);
        GloomCommand.register(server.getCommandManager().getDispatcher());
    }
}
