package xyz.onblock.gloom;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.SimpleMessage;
import xyz.onblock.gloom.server.GloomCommand;
import xyz.onblock.gloom.server.GloomServerMod;

public class Gloomy implements ModInitializer {
	private static Logger LOGGER = LogManager.getLogger("GloomyLit", massageFactory());
	private static Gloomy INSTANCE;
	private static String PREFIX = "[GloomyLit] ";
	public static MinecraftServer server;

	@Override
	public void onInitialize() {
		INSTANCE = this;
		LOGGER.info("Running GloomyLit!");
	}

	public static Gloomy getInstance() {
		if (INSTANCE == null)
			throw new RuntimeException(PREFIX + "Its too early to get a static instance of Gloomy!");

		return INSTANCE;
	}

	public MinecraftServer getServer() {
		if (server == null)
			throw new RuntimeException(PREFIX + "Server isn't set!");

		return server;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static void setServer(MinecraftServer srv) {
		server = srv;
		GloomServerMod.init(srv);
	}

	private static MessageFactory massageFactory() {
		return new MessageFactory() {
			@Override
			public Message newMessage(Object message) {
				return new SimpleMessage(PREFIX + message);
			}

			@Override
			public Message newMessage(String message) {
				return new SimpleMessage(PREFIX + message);
			}

			@Override
			public Message newMessage(String message, Object... params) {
				return new SimpleMessage(PREFIX + message);
			}
		};
	}
}
