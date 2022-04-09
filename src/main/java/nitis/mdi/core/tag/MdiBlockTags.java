package nitis.mdi.core.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import nitis.mdi.Mdi;

public class MdiBlockTags {
    public static final TagKey<Block> END_FIRE_BASE = register("end_fire_base");

    private MdiBlockTags() {
    }

    private static TagKey<Block> register(String id) {
        return TagKey.of(Registry.BLOCK_KEY, Mdi.idOf(id));
    }
}
