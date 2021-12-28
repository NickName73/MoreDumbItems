package nitis.mdi.core;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteAxe extends AxeItem {
    public DioliteAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings.group(Mdi.weaponGroup).rarity(Rarity.RARE).fireproof());
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip)
            tooltip.add(Mdi.getDioliteTooltip());
    }
}
