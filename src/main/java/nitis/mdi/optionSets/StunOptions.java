package nitis.mdi.optionSets;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class StunOptions {

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = 0, max = 60)
    @ConfigEntry.Gui.Tooltip
    public float firstLevelTime = 3;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = 0, max = 60)
    @ConfigEntry.Gui.Tooltip
    public float increaseStunTime = 0.25f;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = 0, max = 25)
    @ConfigEntry.Gui.Tooltip
    public int stunEffectLevel = 2;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
    @ConfigEntry.Gui.Tooltip
    public float cooldownTime = 5;
}
