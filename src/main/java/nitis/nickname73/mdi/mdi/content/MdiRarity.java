package nitis.nickname73.mdi.mdi.content;

import net.minecraft.util.Formatting;

public enum MdiRarity {
    Support(Formatting.DARK_GRAY.ITALIC),
    LVL1(Formatting.GREEN),
    LVL2(Formatting.BLUE);

    public final Formatting formatting;

    private MdiRarity(Formatting formatting) {
        this.formatting = formatting;
    }
}
