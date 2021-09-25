package nitis.nickname73.mdi.mdi.content;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import nitis.nickname73.mdi.mdi.Mdi;
import nitis.nickname73.mdi.mdi.items.DioliteArmorItem;
import nitis.nickname73.mdi.mdi.items.DioliteBlockItem;
import nitis.nickname73.mdi.mdi.items.DioliteItem;

import static nitis.nickname73.mdi.mdi.Mdi.*;

public class Diolite implements ModInitializer {
    //Diolite Blocks
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
            BOOTS = new DioliteArmorItem(EquipmentSlot.FEET,new FabricItemSettings()
                    .fireproof()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .group(Mdi.mdiWeaponGroup)),
            LEGGINGS = new DioliteArmorItem(EquipmentSlot.LEGS,new FabricItemSettings()
                    .fireproof()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .group(Mdi.mdiWeaponGroup)),
            CHESTPLATE = new DioliteArmorItem(EquipmentSlot.CHEST, new FabricItemSettings()
                    .fireproof()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .group(mdiWeaponGroup)),
            HELMET = new DioliteArmorItem(EquipmentSlot.HEAD, new FabricItemSettings()
                    .fireproof()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .group(mdiWeaponGroup));
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
    }
}
