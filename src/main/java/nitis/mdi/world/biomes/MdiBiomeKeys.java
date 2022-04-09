package nitis.mdi.world.biomes;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import nitis.mdi.Mdi;

public abstract class MdiBiomeKeys {
    public static final RegistryKey<Biome> SATURATED_FIELDS = register("saturated_fields");
    private static RegistryKey<Biome> register(String id) {
        return RegistryKey.of(Registry.BIOME_KEY, Mdi.idOf(id));
    }
}
