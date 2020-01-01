package xyz.onblock.gloom.mixin.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.ServerCommandOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.onblock.gloom.Gloomy;

@Mixin(ServerCommandOutput.class)
public class ServerCommandOutputMixin {

    @Inject(at = @At("RETURN"), method = "<init>")
    private void init(MinecraftServer minecraftServer, CallbackInfo ci) {
        Gloomy.setServer(minecraftServer);
    }

}
