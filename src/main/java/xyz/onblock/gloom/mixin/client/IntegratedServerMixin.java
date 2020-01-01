package xyz.onblock.gloom.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.integrated.IntegratedServer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.onblock.gloom.Gloomy;

@Mixin(IntegratedServer.class)
public class IntegratedServerMixin {

    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At(value = "RETURN", target = "Lnet/minecraft/server/integrated/IntegratedServer;setupServer()Z"), method = "setupServer")
    private void gloomy$Setup(CallbackInfoReturnable<Boolean> cir) {
        Gloomy.setServer(this.client.getServer());
    }

}
