package nitis.mdi.core.tag;

import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class MdiBiomeTags {
    public static final TagKey<Biome> DIOLITE_ISLAND_HAS_STRUCTURE = of("has_structure/diolite_island");

    private MdiBiomeTags() {
    }

    private static TagKey<Biome> of(String id) {
        return TagKey.of(Registry.BIOME_KEY, new Identifier(id));
    }
}
