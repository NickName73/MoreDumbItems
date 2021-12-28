package nitis.mdi.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteSword extends SwordItem {
    public DioliteSword(ToolMaterial toolMaterial, int addDamage, float speed, Settings settings) {
        super(toolMaterial, addDamage, speed, settings.fireproof().rarity(Rarity.RARE).group(Mdi.weaponGroup));
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(Mdi.getDioliteTooltip());
        }
    }
}
