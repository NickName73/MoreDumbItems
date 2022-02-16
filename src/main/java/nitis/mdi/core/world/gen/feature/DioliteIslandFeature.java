package nitis.mdi.core.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.structure.StructurePiecesCollector;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import nitis.mdi.core.structure.DioliteIslandGenerator;

public class DioliteIslandFeature extends StructureFeature<DefaultFeatureConfig> {
    public static final StructureGeneratorFactory GEN = StructureGeneratorFactory.simple(DioliteIslandFeature::canGenerate, DioliteIslandFeature::addPieces);
    public DioliteIslandFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec, GEN);
    }
    private static boolean canGenerate(StructureGeneratorFactory.Context<DefaultFeatureConfig> context) {
        return true;
    }

    private static void addPieces(StructurePiecesCollector collector, net.minecraft.structure.StructurePiecesGenerator.Context<DefaultFeatureConfig> context) {
        DioliteIslandGenerator.Piece piece = new DioliteIslandGenerator.Piece(context.structureManager(), context.chunkPos().getBlockPos(6, 70, 6), DioliteIslandGenerator.randomIsland(context.random()));
        collector.addPiece(piece);
        piece.fillOpenings(piece, collector, context.random());


        collector.shiftInto(context.random(), 48, 70);
    }
}
