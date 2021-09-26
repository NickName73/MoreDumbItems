package nitis.nickname73.mdi.mdi.content;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.items.*;

import static nitis.nickname73.mdi.mdi.Mdi.*;

public class Diolite implements ModInitializer {
    //Diolite Blocks
    public static final FabricItemSettings dioliteSettings = new FabricItemSettings().fireproof().rarity(Rarity.RARE);
    public static final Block
            BLOCK = new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(4.5f,6f)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
                    .strength(4.5f,6f)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .sounds(BlockSoundGroup.METAL));

    //Diolite Items
    public static final Item
            INGOT = new DioliteItem(new FabricItemSettings()
                    .maxCount(64)
                    .group(mdiGroup)),
            RAW = new DioliteItem(new FabricItemSettings()
                    .maxCount(16)
                    .group(mdiGroup)),
            SHARD = new DioliteItem(new FabricItemSettings()
                    .maxCount(64)
                    .group(mdiGroup)),
            NUGGET = new DioliteItem(new FabricItemSettings()
                    .maxCount(64)
                    .group(mdiGroup));
    //Diolite Armour
    public static final ArmorItem
            BOOTS = new DioliteArmorItem(EquipmentSlot.FEET,new FabricItemSettings()),
            LEGGINGS = new DioliteArmorItem(EquipmentSlot.LEGS,new FabricItemSettings()),
            CHESTPLATE = new DioliteArmorItem(EquipmentSlot.CHEST, new FabricItemSettings()),
            HELMET = new DioliteArmorItem(EquipmentSlot.HEAD, new FabricItemSettings());
    public static final SwordItem SWORD = new DioliteSword(MdiToolMaterials.Diolite, 3, -2.4f, dioliteSettings.group(mdiWeaponGroup));
    public static final ShovelItem SHOVEL = new DioliteShovel(MdiToolMaterials.Diolite, 1.5f, -3.0f, dioliteSettings.group(mdiWeaponGroup));
    public static final PickaxeItem PICKAXE = new DiolitePickaxe(MdiToolMaterials.Diolite, 1, -2.8f, dioliteSettings.group(mdiWeaponGroup));
    public static final AxeItem AXE = new DioliteAxe(MdiToolMaterials.Diolite, 5, -3f, dioliteSettings.group(mdiWeaponGroup));
    public static final HoeItem HOE = new DioliteHoe(MdiToolMaterials.Diolite, -4,0.0f, dioliteSettings.group(mdiWeaponGroup));
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite"), RAW);
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite_ingot"), INGOT);
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite_shard"), SHARD);
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite_nugget"), NUGGET);

        Registry.register(Registry.BLOCK, new Identifier(modID, "diolite_block"), BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite_block"), new DioliteBlockItem(BLOCK, new FabricItemSettings()
                .maxCount(64)
                .group(mdiGroup)));
        Registry.register(Registry.BLOCK, new Identifier(modID, "diolite_ingot_block"), INGOT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modID,"diolite_ingot_block"), new DioliteBlockItem(INGOT_BLOCK, new FabricItemSettings()
                .maxCount(64)
                .group(mdiGroup)));
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_armor_boots"), BOOTS);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_armor_leggings"), LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_armor_chestplate"), CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_armor_helmet"), HELMET);

        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_sword"), SWORD);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_shovel"), SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_pickaxe"), PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_axe"), AXE);
        Registry.register(Registry.ITEM, new Identifier(modID, "diolite_hoe"), HOE);
    }
}
