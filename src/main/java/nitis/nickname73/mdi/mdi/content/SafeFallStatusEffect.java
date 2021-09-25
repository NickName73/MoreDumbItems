package nitis.nickname73.mdi.mdi.content;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class SafeFallStatusEffect extends StatusEffect {
    public SafeFallStatusEffect(){
        super(
                StatusEffectCategory.BENEFICIAL,
                0xa4cbde);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float fallDist = entity.fallDistance;
        float dist = 0;
        switch (amplifier){
            case 1:{
                dist = 10;
            }
            case 2:{
                dist = 8;
            }
            case 3:{
                dist = 6;
            }
            default:{
                if(amplifier < 1){
                    dist = 10;
                }else{
                    dist = 4;
                }
            }
        }
        if(entity.getBlockY() < -20){
            entity.setPosition(entity.getBlockX(), 344,entity.getBlockZ());
        }

        if(fallDist > dist){
            entity.fallDistance = dist;
        }
    }
}
