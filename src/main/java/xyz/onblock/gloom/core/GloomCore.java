package xyz.onblock.gloom.core;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import xyz.onblock.gloom.mixin.accessor.LightingProviderAccessor;

public class GloomCore {
    private MinecraftServer server;

    public GloomCore(MinecraftServer server) {
        this.server = server;
    }

    public static void setLight(ServerWorld world, BlockPos pos, int level, int chunkX, int chunkY) {
        ChunkLightProvider provider = ((LightingProviderAccessor) world.getChunkManager().getLightingProvider()).getBlockLightProvider();
        provider.addLightSource(pos, level);
        provider.setLightEnabled(new ChunkPos(chunkX, chunkY), true);
        provider.updateSectionStatus(pos, true);

        world.getChunkManager().getLightingProvider().updateSectionStatus(ChunkSectionPos.from(pos), true);

    }

}
