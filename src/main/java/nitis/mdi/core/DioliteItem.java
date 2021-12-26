package nitis.mdi.core;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import nitis.mdi.Mdi;
import nitis.mdi.MdiConfig;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DioliteItem extends Item {

    private boolean isCharged = false;
    public DioliteItem(Settings settings){
        super(settings.fireproof().rarity(Rarity.RARE).group(Mdi.mainGroup));
    }
    public DioliteItem(Settings settings, boolean isWeapon, boolean isCharged) {
        super(settings.fireproof().rarity(Rarity.RARE));
        settings.group( isWeapon ? Mdi.weaponGroup : Mdi.mainGroup );
        this.isCharged = isCharged;
    }
    public DioliteItem(Settings settings, boolean isCharged, ItemGroup group){
        super(settings.fireproof().rarity(Rarity.RARE));
        settings.group(group);
        this.isCharged = isCharged;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(MdiConfig.config.dioliteItemsTooltip){
            tooltip.add(Mdi.getDioliteTooltip());
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return super.hasGlint(stack) || isCharged;
    }
}
