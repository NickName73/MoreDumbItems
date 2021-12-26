package nitis.mdi;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import nitis.mdi.core.MdiColor;

@Config(name = "mdi")
@Config.Gui.Background("mdi:textures/backgrounds/options.png")
public class ConfigerMenu implements ConfigData {
    @ConfigEntry.Category("potions")
    @ConfigEntry.Gui.RequiresRestart
    public boolean safeFallSaveFromVoidDeath = true;

    @ConfigEntry.Category("potions")
    @ConfigEntry.Gui.RequiresRestart
    public int safeFallSaveFromVoidHeight = -80;

    @ConfigEntry.Category("diolite")
    @ConfigEntry.Gui.RequiresRestart
    public boolean dioliteArmorBonus = true;

    @ConfigEntry.Category("diolite")
    public boolean dioliteArmorBonusTooltip = true;

    @ConfigEntry.Category("diolite")
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
    public MdiColor dioliteArmorBonusColor = MdiColor.GRAY;

    @ConfigEntry.Category("diolite")
    public boolean dioliteItemsTooltip = true;

    @ConfigEntry.Category("diolite")
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
    public MdiColor dioliteItemsTooltipColor = MdiColor.DARK_GRAY;
}
