package nitis.mdi.contlist;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.BuiltinRegistries;
import nitis.mdi.Mdi;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import nitis.mdi.world.biomes.SaturatedEnd;

import static nitis.mdi.world.biomes.MdiBiomeKeys.*;

public class MdiEndBiomes implements ModInitializer {
    @Override
    public void onInitialize() {

        //TheEndBiomes.addHighlandsBiome(SATURATED_FIELDS, 2);
    }

    static {
        //Registry.register(BuiltinRegistries.BIOME, SATURATED_FIELDS, SaturatedEnd.createSaturatedFields());
    }
}
