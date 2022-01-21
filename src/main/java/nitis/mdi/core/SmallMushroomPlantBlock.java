package nitis.mdi.core;

import net.minecraft.block.*;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import nitis.mdi.MdiBlockTags;
import java.util.function.Supplier;

public class SmallMushroomPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    protected Tag<Block> validPlaces;

    public SmallMushroomPlantBlock(Settings settings){
        super(settings);
        validPlaces = MdiBlockTags.GLOWING_MUSHROOM_PLANT_BLOCK;
    }
    public SmallMushroomPlantBlock(Settings settings, Tag<Block> canPlaceAt) {
        super(settings);
        validPlaces = canPlaceAt;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isIn(validPlaces);
    }
}