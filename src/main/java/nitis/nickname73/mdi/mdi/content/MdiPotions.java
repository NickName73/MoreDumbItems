package nitis.nickname73.mdi.mdi.content;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.items.DioliteItem;

public class MdiPotions implements ModInitializer {

    public static StatusEffectInstance getStatusEffect(StatusEffect effect, int seconds, int power, boolean outlineEffect, boolean showParticles){
        return new StatusEffectInstance(
                effect,
                seconds * 20,
                power,
                outlineEffect,
                showParticles);
    }
    public static final Potion SAFE_FALL = new Potion(
            getStatusEffect(MdiEffects.SAFE_FALL,60*3,0,false,true)
    ), LONG_SAFE_FALL = new Potion(
            getStatusEffect(MdiEffects.SAFE_FALL, 60*8,0,false,true)
    );
    @Override
    public void onInitialize() {
        //Safe fall
        Registry.register(Registry.POTION, new Identifier("safe_fall_potion"), SAFE_FALL);
        Registry.register(Registry.POTION, new Identifier("long_safe_fall_potion"), LONG_SAFE_FALL);
        Registry.register(Registry.POTION, new Identifier("strong_safe_fall_potion"), new Potion(
           getStatusEffect(MdiEffects.SAFE_FALL, 90,1,false,true)
        ));
        //Glowing
        Registry.register(Registry.POTION, new Identifier("glowing_potion"), new Potion(
            getStatusEffect(StatusEffects.GLOWING, 60*4 + 30,0,true,false)
        ));
        Registry.register(Registry.POTION, new Identifier("long_glowing_potion"), new Potion(
            getStatusEffect(StatusEffects.GLOWING, 60*9,0,true,false)
        ));
    }
}
