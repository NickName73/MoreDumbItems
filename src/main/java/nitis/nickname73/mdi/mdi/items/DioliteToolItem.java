package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteToolItem extends ToolItem {
    public DioliteToolItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings.fireproof().rarity(Rarity.RARE).maxCount(1).group(Mdi.mdiWeaponGroup));
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
        }
    }
}
