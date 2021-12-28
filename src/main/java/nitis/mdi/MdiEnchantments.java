package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import nitis.mdi.core.enchantments.ConsolidationEnchantment;
import nitis.mdi.core.enchantments.StunEnchantment;

public class MdiEnchantments implements ModInitializer {

    public static final ConsolidationEnchantment CONSOLIDATION_ENCHANTMENT = new ConsolidationEnchantment();
    public static final StunEnchantment STUN_ENCHANTMENT = new StunEnchantment();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ENCHANTMENT, Mdi.idOf("consolidation"), CONSOLIDATION_ENCHANTMENT);
        Registry.register(Registry.ENCHANTMENT, Mdi.idOf("stun"), STUN_ENCHANTMENT);
    }
}
