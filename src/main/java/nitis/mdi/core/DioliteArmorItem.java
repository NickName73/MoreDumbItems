package nitis.mdi.core;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiArmorMaterial;
import nitis.mdi.MdiItems;
import nitis.mdi.MdiStatusEffects;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteArmorItem extends ArmorItem {
    public DioliteArmorItem(EquipmentSlot slot, Settings settings) {
        super(MdiArmorMaterial.DIOLITE_ARMOR_MATERIAL, slot, settings.fireproof().rarity(Rarity.RARE).group(Mdi.weaponGroup));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(doBonusSetEquip && MdiConfig.config.dioliteArmorBonusTooltip)
            tooltip.add(Mdi.getDioliteArmorBonusTooltip());
        if(MdiConfig.config.dioliteItemsTooltip)
            tooltip.add(Mdi.getDioliteTooltip());
    }
    public boolean doBonusSetEquip;

    public void doBonusSet(Entity entity){
        try{
            LivingEntity livingEntity = (LivingEntity)entity;
            if(!livingEntity.hasStatusEffect(MdiStatusEffects.SAFE_FALL) && MdiConfig.config.dioliteArmorBonus){
                livingEntity.addStatusEffect(new StatusEffectInstance(MdiStatusEffects.SAFE_FALL, 120,0, true, false, true));
            }
        }catch (Exception e){

        }
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        LivingEntity livingEntity = (LivingEntity)entity;
        if((
                livingEntity.getEquippedStack(EquipmentSlot.FEET).getItem() == MdiItems.DIOLITE_BOOTS &&
                livingEntity.getEquippedStack(EquipmentSlot.LEGS).getItem() == MdiItems.DIOLITE_LEGGINGS &&
                livingEntity.getEquippedStack(EquipmentSlot.CHEST).getItem() == MdiItems.DIOLITE_CHESTPLATE &&
                livingEntity.getEquippedStack(EquipmentSlot.HEAD).getItem() == MdiItems.DIOLITE_HELMET
        ))
        {
            doBonusSetEquip = true;
            doBonusSet(entity);
        }
        else{
            doBonusSetEquip = false;
        }
        super.inventoryTick(stack,world,entity,slot,selected);
    }
}
