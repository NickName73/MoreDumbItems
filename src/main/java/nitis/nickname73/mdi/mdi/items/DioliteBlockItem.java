package nitis.nickname73.mdi.mdi.items;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteBlockItem extends BlockItem {
    public DioliteBlockItem(Block block, Settings settings) {
        super(block, settings.fireproof().rarity(Rarity.RARE));
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
        }
    }
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack) || stack.hasCustomName();
    }
}
