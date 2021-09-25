package nitis.nickname73.mdi.mdi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class PulsarBlock extends Block {
    public static final BooleanProperty ENABLED = BooleanProperty.of("enabled");
    public PulsarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(ENABLED);
    }
}
