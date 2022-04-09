package nitis.mdi.core;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import nitis.mdi.core.tag.MdiBlockTags;

public class EndFireBlock extends AbstractFireBlock {

    public EndFireBlock(Settings settings){
        super(settings, 2.5f);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isEndFireBase(world.getBlockState(pos.down()));
    }

    public static boolean isEndFireBase(BlockState state) {
        return state.isIn(MdiBlockTags.END_FIRE_BASE);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
