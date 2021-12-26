package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class MdiArmorMaterial {
    public static final ArmorMaterial DIOLITE_ARMOR_MATERIAL = new ArmorMaterial() {
        @Override
        public int getDurability(EquipmentSlot slot) {
            return new int[]{13, 15, 16, 11}[slot.getEntitySlotId()] * 48;

        }
        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return new int[]{4, 7, 9, 4}[slot.getEntitySlotId()];

        }

        @Override
        public int getEnchantability() {
            return 20;
        }

        @Override
        public SoundEvent getEquipSound() {
            return null;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(MdiItems.DIOLITE_INGOT);
        }

        @Override
        public String getName() {
            return "diolite_armor";
        }

        @Override
        public float getToughness() {
            return 4.2f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.4f;
        }
    };
}