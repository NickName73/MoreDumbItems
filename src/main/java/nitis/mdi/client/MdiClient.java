package nitis.mdi.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import nitis.mdi.contlist.MdiBlocks;

@Environment(EnvType.CLIENT)
public class MdiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MdiBlocks.GLOWING_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MdiBlocks.END_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MdiBlocks.END_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MdiBlocks.END_WALL_TORCH, RenderLayer.getCutout());
    }
}
