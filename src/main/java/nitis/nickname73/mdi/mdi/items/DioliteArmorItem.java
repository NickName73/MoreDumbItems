package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import nitis.nickname73.mdi.mdi.content.Diolite;
import nitis.nickname73.mdi.mdi.content.MdiEffects;
import nitis.nickname73.mdi.mdi.content.MdiRarity;
import nitis.nickname73.mdi.mdi.content.ModArmorMaterial;
import org.jetbrains.annotations.Nullable;
import net.minecraft.entity.LivingEntity;

import java.util.List;

public class DioliteArmorItem extends ArmorItem {
    public DioliteArmorItem(EquipmentSlot equipmentSlot, Settings settings) {
        super(ModArmorMaterial.DIOLITE_ARMOR_MATERIAL, equipmentSlot, settings.fireproof().group(Mdi.mdiWeaponGroup).rarity(Rarity.RARE).maxCount(1));
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(doBonusSetEquip && MdiConfig.config.dioliteArmorBonusTooltip)
        tooltip.add(new TranslatableText("tooltip.mdi.diolite_armor_set").formatted(Formatting.GRAY));
        if(MdiConfig.config.dioliteItemsTooltip)
        tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.DARK_GRAY).formatted(Formatting.ITALIC));
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack);
    }
    public boolean doBonusSetEquip;

    public void doBonusSet(Entity entity){
        try{
            LivingEntity livingEntity = (LivingEntity)entity;
            if(!livingEntity.hasStatusEffect(MdiEffects.SAFE_FALL) && MdiConfig.config.dioliteArmorBonus){
                livingEntity.addStatusEffect(new StatusEffectInstance(MdiEffects.SAFE_FALL, 120,0, true, false, true));
            }
        }catch (Exception e){

        }
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(( (LivingEntity)entity ).getEquippedStack(EquipmentSlot.FEET).getItem() == Diolite.BOOTS
            && ((LivingEntity)entity ).getEquippedStack(EquipmentSlot.LEGS).getItem() == Diolite.LEGGINGS
                && ((LivingEntity)entity ).getEquippedStack(EquipmentSlot.CHEST).getItem() == Diolite.CHESTPLATE
                    && ((LivingEntity)entity ).getEquippedStack(EquipmentSlot.HEAD).getItem() == Diolite.HELMET){
                    doBonusSetEquip = true;
                    doBonusSet(entity);
        }else{
            doBonusSetEquip = false;
        }
        super.inventoryTick(stack,world,entity,slot,selected);
    }
}
