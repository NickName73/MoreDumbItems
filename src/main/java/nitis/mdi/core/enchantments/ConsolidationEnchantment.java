package nitis.mdi.core.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ThornsEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;

public class ConsolidationEnchantment extends Enchantment {
    public ConsolidationEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[] { EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD });
    }
    @Override
    public int getMinPower(int level) { return (level - 1) * 5; }

    @Override
    public int getMaxLevel() {
        return 6;
    }

    @Override
    public int getProtectionAmount(int level, DamageSource source) {
        if (source.bypassesArmor() || source.isUnblockable()) {
            if (source.isOutOfWorld()) {
                return 0;
            }
            if(source.isExplosive() || source.isFallingBlock()) {
                return level * 2;
            }
            if(source.isFire()){
                return level;
            }
            return level / 2;
        } else
            return 0;
    }

    @Override
    public final boolean canAccept(Enchantment other) {
        return !(other instanceof ThornsEnchantment);
    }
    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }
}
