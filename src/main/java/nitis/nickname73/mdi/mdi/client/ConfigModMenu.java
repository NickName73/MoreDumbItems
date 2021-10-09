package nitis.nickname73.mdi.mdi.client;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = "mdi")
@Config.Gui.Background("minecraft:textures/block/dirt.png")
public class ConfigModMenu implements ConfigData {
    @ConfigEntry.Gui.RequiresRestart
    public boolean dioliteArmorBonus = true;
    public boolean dioliteArmorBonusTooltip = true;
    public boolean dioliteItemsTooltip = true;
}
