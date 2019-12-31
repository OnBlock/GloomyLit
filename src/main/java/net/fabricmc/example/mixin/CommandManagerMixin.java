package net.fabricmc.example.mixin;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CommandManager.class)
public interface CommandManagerMixin {

	@Accessor("dispatcher")
	CommandDispatcher<ServerCommandSource> getDispatcher();

}
