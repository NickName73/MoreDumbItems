package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteShovel extends ShovelItem {

    public DioliteShovel(ToolMaterial toolMaterial, float addDamage, float speed, Settings settings) {
        super(toolMaterial, addDamage, speed, settings);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
        }
    }
}
