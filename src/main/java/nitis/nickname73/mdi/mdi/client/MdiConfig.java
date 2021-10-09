package nitis.nickname73.mdi.mdi.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class MdiConfig implements ModInitializer {

    public static ConfigModMenu config = new ConfigModMenu();
    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigModMenu.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ConfigModMenu.class).getConfig();
    }
}
