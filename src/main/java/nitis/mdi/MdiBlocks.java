package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class MdiBlocks implements ModInitializer {

    public static final Block DIOLITE_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
            .strength(5.25f,10f)
            .breakByTool(FabricToolTags.PICKAXES)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block DIOLITE_INGOT_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
                    .strength(4.75f,12f)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .sounds(BlockSoundGroup.METAL));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_block"), DIOLITE_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_ingot_block"), DIOLITE_INGOT_BLOCK);
    }
}
