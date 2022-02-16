package nitis.mdi.core.structure;

import com.google.common.collect.Lists;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import nitis.mdi.Mdi;

import java.util.List;
import java.util.Random;

public class DioliteIslandGenerator {
    public static final Identifier[] ISLANDS = new Identifier[]{Mdi.idOf("diolite_island/array_1"), Mdi.idOf("diolite_island/small_1"), Mdi.idOf("diolite_island/small_2"), Mdi.idOf("diolite_island/small_3")};
    public DioliteIslandGenerator(){}

    public static Identifier randomIsland(Random random){
        return ISLANDS[random.nextInt(ISLANDS.length)];
    }

    public static class Piece extends SimpleStructurePiece {
        public Piece(StructureManager manager, BlockPos pos, Identifier island) {
            super(StructurePieceType.END_CITY, 0, manager, island, island.toString(), createPlacementData(), pos);
        }

        public Piece(StructureManager manager, NbtCompound nbt) {
            super(StructurePieceType.END_CITY, nbt, manager, (id) -> {
                return createPlacementData();
            });
        }

        private static StructurePlacementData createPlacementData() {
            return (new StructurePlacementData()).setMirror(BlockMirror.NONE).addProcessor(BlockIgnoreStructureProcessor.IGNORE_AIR_AND_STRUCTURE_BLOCKS);
        }

        protected void writeNbt(StructureContext context, NbtCompound nbt) {
            super.writeNbt(context, nbt);
        }

        protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox) {
        }

        public void generate(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pos) {
            chunkBox.encompass(this.structure.calculateBoundingBox(this.placementData, this.pos));
            super.generate(world, structureAccessor, chunkGenerator, random, chunkBox, chunkPos, pos);
        }
    }
}
