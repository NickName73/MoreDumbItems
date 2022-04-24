package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import nitis.mdi.contlist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mdi implements ModInitializer {

    public final static String MOD_ID = "mdi";
    public final static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static ItemGroup mainGroup = FabricItemGroupBuilder
            .create(idOf("main"))
            .icon(() -> new ItemStack(MdiItems.RAW_DIOLITE))
            .build();
    public static ItemGroup weaponGroup = FabricItemGroupBuilder
            .create(idOf("weapon"))
            .icon(() -> new ItemStack(MdiItems.DIOLITE_SWORD))
            .build();

    @Override
    public void onInitialize() {
        new MdiStatusEffects().onInitialize();
        new MdiPotions().onInitialize();
        new MdiBlocks().onInitialize();
        new MdiItems().onInitialize();
        new MdiCommands().onInitialize();
        new MdiEnchantments().onInitialize();
    }
    public static MutableText getDioliteTooltip(){
        return MdiConfig.config.dioliteItemsTooltipColor.format(new TranslatableText("tooltip.mdi.diolite"));
    }
    public static MutableText getDioliteArmorBonusTooltip() {
        return MdiConfig.config.dioliteArmorBonusColor.format(new TranslatableText("tooltip.mdi.diolite_armor_set"));
    }
    public static Identifier idOf(String name){
        return new Identifier(MOD_ID,name);
    }


    public static int getTickTime(float time){
        return (int)time * 20;
    }

    public static int getStunTimeAmount(int level) {
        return Mdi.getTickTime( MdiConfig.config.stunOptions.firstLevelTime + MdiConfig.config.stunOptions.increaseStunTime * level);
    }
    public static int getStunCooldown(int level) {
        return getTickTime(MdiConfig.config.stunOptions.cooldownTime);
    }
}
