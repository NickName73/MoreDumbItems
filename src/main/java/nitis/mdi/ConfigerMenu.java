package nitis.mdi;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import nitis.mdi.core.MdiColor;
import nitis.mdi.optionSets.StunOptions;
import nitis.mdi.optionSets.SafeFallOptions;

@Config(name = "mdi")
@Config.Gui.Background("mdi:textures/background/options.png")
public class ConfigerMenu implements ConfigData {
    @ConfigEntry.Category("enchantments")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public StunOptions stunOptions = new StunOptions();

    @ConfigEntry.Category("potions")
    @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
    public SafeFallOptions safeFallOptions = new SafeFallOptions();

    //region DIOLITE
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
    //endregion
    //region COMMANDS
    @ConfigEntry.Category("commands")
    @ConfigEntry.Gui.RequiresRestart
    public boolean hungerCommand = true;

    @ConfigEntry.Category("commands")
    @ConfigEntry.Gui.RequiresRestart
    public boolean healthCommand = true;

    @ConfigEntry.Category("commands")
    @ConfigEntry.Gui.RequiresRestart
    public boolean chatClearCommand = true;
    //endregion
}
