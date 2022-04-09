package nitis.mdi.contlist;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import nitis.mdi.Mdi;
import nitis.mdi.tags.MdiBlockTags;
import nitis.mdi.core.MdiMaterial;
import nitis.mdi.core.EndFireBlock;
import nitis.mdi.core.EndTorchBlock;
import nitis.mdi.core.GlowingMushroomPlantBlock;
import nitis.mdi.core.WallEndTorchBlock;

public class MdiBlocks implements ModInitializer {

    public static final Block DIOLITE_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
                    .strength(5.25f,10f)
                    //.breakByTool(FabricToolTags.PICKAXES, 2)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block DIOLITE_INGOT_BLOCK = new Block(FabricBlockSettings.of(MdiMaterial.DIOLITE)
                    .strength(4.75f,12f)
                    //.breakByTool(FabricToolTags.PICKAXES, 2)
                    .sounds(BlockSoundGroup.METAL));
    public static final GlowingMushroomPlantBlock GLOWING_MUSHROOM = new GlowingMushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.LIGHT_BLUE)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .luminance(3),
                    MdiBlockTags.GLOWING_MUSHROOM_PLANT_BLOCK,
                    () -> TreeConfiguredFeatures.JUNGLE_BUSH);
    public static final Block GLOWING_MUSHROOM_STEM = new MushroomBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GRAY)
                    .luminance(6)
                    .sounds(BlockSoundGroup.WOOL)
                    .strength(0.2f));
    public static final Block GLOWING_MUSHROOM_BLOCK = new MushroomBlock(FabricBlockSettings.of(Material.WOOD, MapColor.GRAY)
                    .luminance(8)
                    .strength(0.2f));
    public static final Block ONIUM = new Block(FabricBlockSettings.of(Material.STONE, MapColor.PURPLE)
                    .strength(3.0F, 9.0F)
                    //.breakByTool(FabricToolTags.PICKAXES, 0)
                    .sounds(BlockSoundGroup.AZALEA));

    public static final Block END_FIRE = new EndFireBlock(FabricBlockSettings.of(Material.FIRE)
                        .sounds(BlockSoundGroup.WOOD)
                        .breakInstantly()
                        .noCollision()
                        .luminance(10));
    public static final Block END_TORCH = new EndTorchBlock(FabricBlockSettings.of(Material.DECORATION)
                        .luminance(12)
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.WOOD)
                        );
    public static final Block END_WALL_TORCH = new WallEndTorchBlock(FabricBlockSettings.of(Material.DECORATION)
                        .luminance(12)
                        .noCollision()
                        .breakInstantly()
                        .sounds(BlockSoundGroup.WOOD)
    );
    public static final LanternBlock END_LANTERN = new LanternBlock(FabricBlockSettings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(7).nonOpaque());

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_block"), DIOLITE_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("diolite_ingot_block"), DIOLITE_INGOT_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("onium"), ONIUM);
        Registry.register(Registry.BLOCK, Mdi.idOf("glowing_mushroom"), GLOWING_MUSHROOM);
        Registry.register(Registry.BLOCK, Mdi.idOf("glowing_mushroom_stem"), GLOWING_MUSHROOM_STEM);
        Registry.register(Registry.BLOCK, Mdi.idOf("glowing_mushroom_block"), GLOWING_MUSHROOM_BLOCK);
        Registry.register(Registry.BLOCK, Mdi.idOf("end_torch"), END_TORCH);
        Registry.register(Registry.BLOCK, Mdi.idOf("end_wall_torch"), END_WALL_TORCH);
        Registry.register(Registry.BLOCK, Mdi.idOf("end_lantern"), END_LANTERN);
        Registry.register(Registry.BLOCK, Mdi.idOf("end_fire"), END_FIRE);

    }
}
