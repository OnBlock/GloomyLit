package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.SimpleMessage;

public class Gloomy implements ModInitializer {
	public static Logger LOGGER = LogManager.getLogger("GloomyLit", massageFactory());

	@Override
	public void onInitialize() {

	}

	private static MessageFactory massageFactory() {
		String PREFIX = "[GloomyLit] ";
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
