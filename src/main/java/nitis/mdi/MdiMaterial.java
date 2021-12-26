package nitis.mdi;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public final class MdiMaterial {
    public static final Material DIOLITE;

    static {
        DIOLITE = new Material.Builder(MapColor.MAGENTA).build();
    }
}
