package nitis.mdi.option.sets;

import me.shedaniel.autoconfig.annotation.ConfigEntry;

public class SafeFallOptions {

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.Gui.Tooltip
    public boolean safeFallSaveFromVoidDeath = true;

    @ConfigEntry.Gui.RequiresRestart
    @ConfigEntry.BoundedDiscrete(min = -2048, max = 0)
    @ConfigEntry.Gui.Tooltip
    public int safeFallSaveFromVoidHeight = -80;
}
