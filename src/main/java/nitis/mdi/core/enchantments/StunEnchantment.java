package nitis.mdi.core.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import nitis.mdi.core.Hook;

public class StunEnchantment extends Enchantment {
    public StunEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof Hook;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return -0.5f;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public final boolean canAccept(Enchantment other) {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, Mdi.getStunTimeAmount(level), MdiConfig.config.stunOptions.stunEffectLevel, true, false));
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, Mdi.getStunTimeAmount(level), MdiConfig.config.stunOptions.stunEffectLevel, true, false));
            PlayerEntity player = (PlayerEntity)user;
            player.getItemCooldownManager().set( user.getMainHandStack().getItem(), Mdi.getStunCooldown(level));
        }

        super.onTargetDamaged(user, target, level);
    }
}
