package xyz.onblock.gloom.server;

import net.minecraft.server.MinecraftServer;
import xyz.onblock.gloom.Gloomy;

public class GloomServerMod {
    public static void init(MinecraftServer server) {
        GloomCommand.register(server.getCommandManager().getDispatcher());
    }
}
