package nitis.mdi.mixins;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import nitis.mdi.Mdi;
import nitis.mdi.world.biomes.MdiBiomeKeys;
import nitis.mdi.world.biomes.SaturatedEnd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltinBiomes.class)
public class BiomeAccessor {
    @Inject(at = @At("TAIL"), method = "<clinit>")
    private static void clinit(CallbackInfo info) {
        invokeRegister(MdiBiomeKeys.SATURATED_FIELDS, SaturatedEnd.createSaturatedFields());
    }

    @Invoker
    public static void invokeRegister(RegistryKey<Biome> key, Biome biome) {
        Mdi.LOGGER.info("Registry new biome %s", key.getValue());
    }
}
