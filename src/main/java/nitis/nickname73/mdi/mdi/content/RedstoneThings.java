package nitis.nickname73.mdi.mdi.content;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nitis.nickname73.mdi.mdi.blocks.PulsarBlock;

import static nitis.nickname73.mdi.mdi.Mdi.modID;

public class RedstoneThings implements ModInitializer {

    public static final Block PULSAR = new PulsarBlock(FabricBlockSettings.of(Material.PISTON)
                    .strength(1f,2f)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .sounds(BlockSoundGroup.STONE)
                    .breakByHand(true)
                    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier(modID,"pulsar"), PULSAR);
    }
}
