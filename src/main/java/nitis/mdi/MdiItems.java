package nitis.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;
import nitis.mdi.core.DioliteArmorItem;
import nitis.mdi.core.DioliteItem;
import nitis.mdi.core.DioliteBlockItem;
import nitis.mdi.core.DioliteSword;

public class MdiItems implements ModInitializer {

    public final static DioliteItem RAW_DIOLITE = new DioliteItem(new FabricItemSettings().maxCount(16));
    public final static DioliteItem DIOLITE_INGOT = new DioliteItem(new FabricItemSettings());
    public final static DioliteItem DIOLITE_INGOT_CHARGED = new DioliteItem(new FabricItemSettings(), true, null);
    public final static DioliteItem DIOLITE_SHARD = new DioliteItem(new FabricItemSettings());
    public final static DioliteItem DIOLITE_NUGGET = new DioliteItem(new FabricItemSettings());

    public final static DioliteArmorItem DIOLITE_BOOTS = new DioliteArmorItem(EquipmentSlot.FEET, new FabricItemSettings());
    public final static DioliteArmorItem DIOLITE_LEGGINGS = new DioliteArmorItem(EquipmentSlot.LEGS, new FabricItemSettings());
    public final static DioliteArmorItem DIOLITE_CHESTPLATE = new DioliteArmorItem(EquipmentSlot.CHEST, new FabricItemSettings());
    public final static DioliteArmorItem DIOLITE_HELMET = new DioliteArmorItem(EquipmentSlot.HEAD, new FabricItemSettings());

    public final static DioliteSword DIOLITE_SWORD = new DioliteSword(MdiToolMaterials.DIOLITE, 3, -2.4f, new FabricItemSettings());

    @Override
    public void onInitialize() {
        //Block items
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_block"), new DioliteBlockItem(MdiBlocks.DIOLITE_BLOCK, new FabricItemSettings()));
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot_block"), new DioliteBlockItem(MdiBlocks.DIOLITE_INGOT_BLOCK, new FabricItemSettings()));
        //Resources
        Registry.register(Registry.ITEM, Mdi.idOf("diolite"), RAW_DIOLITE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot"), DIOLITE_INGOT);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot_charge"), DIOLITE_INGOT_CHARGED);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_shard"), DIOLITE_SHARD);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_nugget"), DIOLITE_NUGGET);
        //Weapons & armour
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_boots"), DIOLITE_BOOTS);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_leggings"), DIOLITE_LEGGINGS);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_chestplate"), DIOLITE_CHESTPLATE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_helmet"), DIOLITE_HELMET);

        Registry.register(Registry.ITEM, Mdi.idOf("diolite_sword"), DIOLITE_SWORD);
    }
}
