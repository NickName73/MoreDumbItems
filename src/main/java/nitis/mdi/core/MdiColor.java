package nitis.mdi.core;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public enum MdiColor {
    BLACK(Formatting.BLACK),
    DARK_GRAY(Formatting.DARK_GRAY),
    GRAY(Formatting.GRAY),
    WHITE(Formatting.WHITE),
    RED(Formatting.RED),
    DARK_RED(Formatting.DARK_RED),
    YELLOW(Formatting.YELLOW),
    GOLD(Formatting.GOLD),
    GREEN(Formatting.GREEN),
    DARk_GREEN(Formatting.DARK_GREEN),
    BLUE(Formatting.BLUE),
    DARK_BLUE(Formatting.DARK_BLUE),
    AQUA(Formatting.AQUA),
    DARK_AQUA(Formatting.DARK_AQUA),
    PURPLE(Formatting.LIGHT_PURPLE),
    DARK_PURPLE(Formatting.DARK_PURPLE);

    private Formatting format;
    public MutableText format(TranslatableText text){
        return text.formatted(format);
    }
    public Formatting getFormat(){
        return format;
    }
    private MdiColor(Formatting format){
        this.format = format;
    }
    public static MutableText apply(MutableText text, MdiColor color){
        return text.formatted(color.format);
    }
}
