package nitis.nickname73.mdi.mdi.content;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static nitis.nickname73.mdi.mdi.Mdi.modID;

public class MdiEffects implements ModInitializer {

    public static final SafeFallStatusEffect SAFE_FALL = new SafeFallStatusEffect();
    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT,new Identifier(modID,"safe_fall"),SAFE_FALL);
    }
}
