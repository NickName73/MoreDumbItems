package nitis.mdi.client;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class MdiConfig implements ModInitializer {

    public static ConfigerMenu config = new ConfigerMenu();
    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigerMenu.class, JanksonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(ConfigerMenu.class).getConfig();
    }
    public static ConfigerMenu options(){
        return config;
    }
}