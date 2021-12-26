package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import nitis.mdi.core.effects.SafeFallStatusEffect;

public class MdiStatusEffects implements ModInitializer {

    public static final SafeFallStatusEffect SAFE_FALL = new SafeFallStatusEffect();

    @Override
    public void onInitialize() {
        Registry.register(Registry.STATUS_EFFECT, Mdi.idOf("safe_fall"), SAFE_FALL);
    }
}
