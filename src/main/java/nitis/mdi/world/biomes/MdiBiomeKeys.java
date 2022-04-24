package nitis.mdi.world.biomes;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import nitis.mdi.Mdi;

public abstract class MdiBiomeKeys {
    public static final Identifier SATURATED_FIELDS_ID = Mdi.idOf("saturated_fields");
    public static final RegistryKey<Biome> SATURATED_FIELDS = register(SATURATED_FIELDS_ID);
    private static RegistryKey<Biome> register(Identifier id) {
        return RegistryKey.of(Registry.BIOME_KEY, id);
    }
}
