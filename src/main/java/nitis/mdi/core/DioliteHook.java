package nitis.mdi.core;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DioliteHook extends Hook {

    public DioliteHook(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, ArrayList<TagKey<Block>> effectiveBlocks, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, effectiveBlocks, settings.fireproof().rarity(Rarity.RARE));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip)
            tooltip.add(Mdi.getDioliteTooltip());
    }
}
