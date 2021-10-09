package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import nitis.nickname73.mdi.mdi.content.Hook;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteHook extends Hook {
    public DioliteHook(ToolMaterial toolMaterial, int i, float f, Settings settings) {
        super(toolMaterial, i, f, settings.fireproof().rarity(Rarity.RARE));
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
        }
    }
}
