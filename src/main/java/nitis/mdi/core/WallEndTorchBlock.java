package nitis.mdi.core;

import net.minecraft.block.WallTorchBlock;
import net.minecraft.particle.ParticleTypes;

public class WallEndTorchBlock extends WallTorchBlock {
    public WallEndTorchBlock(Settings settings) {
        super(settings, ParticleTypes.ANGRY_VILLAGER);
    }
}
