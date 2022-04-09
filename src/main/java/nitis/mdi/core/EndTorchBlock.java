package nitis.mdi.core;

import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleTypes;

public class EndTorchBlock extends TorchBlock {
    public EndTorchBlock(Settings settings) {
        super(settings, ParticleTypes.ANGRY_VILLAGER);
    }
}
