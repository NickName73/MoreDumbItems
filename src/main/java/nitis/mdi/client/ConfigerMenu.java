package nitis.mdi.client;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "mdi")
@Config.Gui.Background("mdi:textures/backgrounds/options.png")
public class ConfigerMenu implements ConfigData {
    @ConfigEntry.Gui.RequiresRestart
    public boolean dioliteArmorBonus = true;
    public boolean dioliteArmorBonusTooltip = true;
    public boolean dioliteItemsTooltip = true;
}
