package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteItem extends Item {
    public DioliteItem(Settings settings) {
        super(settings.fireproof().rarity(Rarity.RARE));
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
    }
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack) || stack.hasCustomName();
    }
}
