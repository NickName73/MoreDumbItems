package nitis.mdi.contlist;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nitis.mdi.Mdi;
import nitis.mdi.mixins.BrewingRecipeRegistryAccessor;

import java.util.Optional;

public class MdiPotions implements ModInitializer {

    public static final Potion SAFE_FALL = new Potion(
            createPotion(MdiStatusEffects.SAFE_FALL,60*3,0,false,true)
    );
    public static final Potion LONG_SAFE_FALL = new Potion(
            createPotion(MdiStatusEffects.SAFE_FALL, 60*8,0,false,true)
    );
    public static final Potion STRONG_SAFE_FALL = new Potion(
            createPotion(MdiStatusEffects.SAFE_FALL, 90, 1, false, true)
    );
    public static final Potion GLOWING = new Potion(
            createPotion(StatusEffects.GLOWING,60*4,0,true,false)
    );
    public static final Potion LONG_GLOWING = new Potion(
            createPotion(StatusEffects.GLOWING, 60*9,0,true,false)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.POTION, Mdi.idOf("safe_fall_potion"), SAFE_FALL);
        Registry.register(Registry.POTION, Mdi.idOf("long_safe_fall_potion"), LONG_SAFE_FALL);
        Registry.register(Registry.POTION, Mdi.idOf("strong_safe_fall_potion"), STRONG_SAFE_FALL);
        Registry.register(Registry.POTION, Mdi.idOf("glowing_potion"), GLOWING);
        Registry.register(Registry.POTION, Mdi.idOf("long_glowing_potion"), LONG_GLOWING);

        mapPotions(Potions.NIGHT_VISION, Items.GLOW_INK_SAC, MdiPotions.GLOWING);
        mapPotions(Potions.AWKWARD, MdiItems.GLOWING_MUSHROOM, MdiPotions.GLOWING);
        variantRecipes(MdiPotions.GLOWING);

        mapPotions(Potions.AWKWARD, MdiItems.DIOLITE_SHARD, MdiPotions.SAFE_FALL);
        variantRecipes(MdiPotions.SAFE_FALL);
    }

    public static StatusEffectInstance createPotion(StatusEffect effect, int seconds, int power, boolean outlineEffect, boolean showParticles){
        return new StatusEffectInstance(
                effect,
                seconds * 20,
                power,
                outlineEffect,
                showParticles);
    }

    private static void mapPotions(Potion in, Item ingredient, Potion result) {
        Identifier potionInId = Registry.POTION.getId(in);
        Identifier potionOutId = Registry.POTION.getId(result);
        Optional<Potion> inLong = Registry.POTION.getOrEmpty(new Identifier(potionInId.getNamespace(), "long_" + potionInId.getPath()));
        Optional<Potion> inStrong = Registry.POTION.getOrEmpty(new Identifier(potionInId.getNamespace(), "strong_" + potionInId.getPath()));
        Optional<Potion> outLong = Registry.POTION.getOrEmpty(new Identifier(potionOutId.getNamespace(), "long_" + potionOutId.getPath()));
        Optional<Potion> outStrong = Registry.POTION.getOrEmpty(new Identifier(potionOutId.getNamespace(), "strong_" + potionOutId.getPath()));
        if(outLong.isPresent() && inLong.isPresent()) {
            BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(inLong.get(), ingredient, outLong.get());
        }
        if(outStrong.isPresent() && inStrong.isPresent()) {
            BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(inStrong.get(), ingredient, outStrong.get());
        }
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(in, ingredient, result);
    }

    private static void variantRecipes(Potion potion) {
        Identifier id = Registry.POTION.getId(potion);
        Optional<Potion> lengthy = Registry.POTION.getOrEmpty(new Identifier(id.getNamespace(), "long_" + id.getPath()));
        Optional<Potion> strong = Registry.POTION.getOrEmpty(new Identifier(id.getNamespace(), "strong_" + id.getPath()));
        if(lengthy.isPresent()) {
            BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(potion, Items.REDSTONE, lengthy.get());
        }
        if(strong.isPresent()) {
            BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(potion, Items.GLOWSTONE_DUST, strong.get());
        }
    }
}
