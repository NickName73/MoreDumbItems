package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import nitis.mdi.core.SmallMushroomPlantBlock;

public class MdiBlocks implements ModInitializer {

    public static final Block DIOLITE_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
                    .strength(5.25f,10f)
                    .breakByTool(FabricToolTags.PICKAXES, 2)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block DIOLITE_INGOT_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
                    .strength(4.75f,12f)
                    .breakByTool(FabricToolTags.PICKAXES, 2)
                    .sounds(BlockSoundGroup.METAL));
    public static final SmallMushroomPlantBlock GLOWING_MUSHROOM = new SmallMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.LIGHT_BLUE)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .luminance(3));
    public static final Block ONIUM = new Block(FabricBlockSettings.of(Material.STONE, MapColor.PURPLE)
                    .strength(3.0F, 9.0F)
                    .breakByTool(FabricToolTags.PICKAXES, 0)
                    .sounds(BlockSoundGroup.AZALEA));

    public static final LanternBlock END_LANTERN = new LanternBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(7).nonOpaque());

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_block"), DIOLITE_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_ingot_block"), DIOLITE_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("onium"), ONIUM);
        Registry.register(Registry.BLOCK, Mdi.idOf("glowing_mushroom"), GLOWING_MUSHROOM);
        Registry.register(Registry.BLOCK, Mdi.idOf("end_lantern"), END_LANTERN);
    }
}
