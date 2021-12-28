package nitis.mdi.core.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import nitis.mdi.MdiConfig;

public class SafeFallStatusEffect extends StatusEffect {
    public SafeFallStatusEffect(){
        super(StatusEffectCategory.BENEFICIAL,0x9784f9);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //Current fall distance
        float fallDist = entity.fallDistance;
        //Distance to activate absorb fall damage
        float dist = 0;
        dist = 12 - (amplifier * 2);

        if(entity.getBlockY() < MdiConfig.config.safeFallOptions.safeFallSaveFromVoidHeight && MdiConfig.config.safeFallOptions.safeFallSaveFromVoidDeath){
            entity.setPosition(entity.getBlockX(), 560,entity.getBlockZ());
        }

        if(fallDist >= dist){
            entity.fallDistance = dist;
        }
    }
}