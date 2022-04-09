package nitis.mdi.tags;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import nitis.mdi.Mdi;

public final class MdiBlockTags {
    public static final TagKey<Block> GLOWING_MUSHROOM_PLANT_BLOCK = TagKey.of(Registry.BLOCK_KEY, Mdi.idOf("glowing_mushroom_plant_block"));
}
