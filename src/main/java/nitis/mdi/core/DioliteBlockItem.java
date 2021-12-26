package nitis.mdi.core;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteBlockItem extends BlockItem {
    public DioliteBlockItem(Block block, Settings settings) {
        super(block, settings.fireproof().rarity(Rarity.RARE).group(Mdi.mainGroup));
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip) {
            tooltip.add(Mdi.getDioliteTooltip());
        }
    }
}