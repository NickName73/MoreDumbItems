package nitis.nickname73.mdi.mdi.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.content.Diolite;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteSword extends SwordItem {
    public DioliteSword(ToolMaterial toolMaterial, int addDamage, float speed, Settings settings) {
        super(toolMaterial, addDamage, speed, Diolite.dioliteSettings.group(Mdi.mdiWeaponGroup).maxCount(1));
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.mdi.diolite").formatted(Formatting.ITALIC).formatted(Formatting.DARK_GRAY));
    }
}
