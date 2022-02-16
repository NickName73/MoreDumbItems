package nitis.mdi;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import nitis.mdi.core.world.gen.feature.DioliteIslandFeature;

public class MdiStructures implements ModInitializer {
    public static final Identifier DIOLITE_ISLAND_ID = Mdi.idOf("diolite_island");
    public static final StructureFeature<DefaultFeatureConfig> DIOLITE_ISLAND_FEATURE = new DioliteIslandFeature(DefaultFeatureConfig.CODEC);

    @Override
    public void onInitialize() {
        /*FabricStructureBuilder.create(DIOLITE_ISLAND_ID, DIOLITE_ISLAND_FEATURE)
                .step(GenerationStep.Feature.RAW_GENERATION)
                .defaultConfig(512, 30, 2)
                .register();*/
    }
}
