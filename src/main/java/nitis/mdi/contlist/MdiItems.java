package nitis.mdi.contlist;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.registry.Registry;
import nitis.mdi.Mdi;
import nitis.mdi.core.MdiToolMaterials;
import nitis.mdi.core.*;

public class MdiItems implements ModInitializer {

    public static final BlockItem DIOLITE_BLOCK = new DioliteBlockItem(MdiBlocks.DIOLITE_BLOCK, new FabricItemSettings());
    public static final BlockItem DIOLITE_INGOT_BLOCK = new DioliteBlockItem(MdiBlocks.DIOLITE_INGOT_BLOCK, new FabricItemSettings());
    public static final BlockItem ONIUM = new BlockItem(MdiBlocks.ONIUM, new FabricItemSettings().group(Mdi.mainGroup));
    public static final BlockItem GLOWING_MUSHROOM = new BlockItem(MdiBlocks.GLOWING_MUSHROOM, new FabricItemSettings().group(Mdi.mainGroup));
    public static final BlockItem GLOWING_MUSHROOM_STEM = new BlockItem(MdiBlocks.GLOWING_MUSHROOM_STEM, new FabricItemSettings().group(Mdi.mainGroup));
    public static final BlockItem GLOWING_MUSHROOM_BLOCK = new BlockItem(MdiBlocks.GLOWING_MUSHROOM_BLOCK, new FabricItemSettings().group(Mdi.mainGroup));
    public static final BlockItem END_TORCH = new WallStandingBlockItem(MdiBlocks.END_TORCH, MdiBlocks.END_WALL_TORCH, new FabricItemSettings().group(Mdi.mainGroup));

    public static final BlockItem END_LANTERN = new BlockItem(MdiBlocks.END_LANTERN, new FabricItemSettings().group(Mdi.mainGroup));

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
    public final static DioliteShovel DIOLITE_SHOVEL = new DioliteShovel(MdiToolMaterials.DIOLITE, 1.5f, -3.0f, new FabricItemSettings());
    public final static DiolitePickaxe DIOLITE_PICKAXE = new DiolitePickaxe(MdiToolMaterials.DIOLITE, 1, -2.8f, new FabricItemSettings());
    public static final DioliteAxe DIOLITE_AXE = new DioliteAxe(MdiToolMaterials.DIOLITE, 5, -3f, new FabricItemSettings());
    public static final DioliteHoe DIOLITE_HOE = new DioliteHoe(MdiToolMaterials.DIOLITE, -4,0.0f, new FabricItemSettings());

    public static final Hook WOODEN_HOOK = new Hook(ToolMaterials.WOOD, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final Hook IRON_HOOK = new Hook(ToolMaterials.IRON, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final Hook GOLD_HOOK = new Hook(ToolMaterials.GOLD, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final Hook DIAMOND_HOOK = new Hook(ToolMaterials.DIAMOND, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final Hook NETHERITE_HOOK = new Hook(ToolMaterials.NETHERITE, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final DioliteHook DIOLITE_HOOK = new DioliteHook(MdiToolMaterials.DIOLITE, 4, 7f, Hook.hookEffectiveBlocks, new FabricItemSettings().group(Mdi.weaponGroup));
    public static final Item LIFE_FRUIT = new StatusEffectFoodItem(new FabricItemSettings().group(Mdi.mainGroup), new FoodComponent.Builder().alwaysEdible().hunger(6).saturationModifier(0.2f), new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 90 * 20, 6));
    public static final Item CHOCOLATE = new Item(new FabricItemSettings().group(Mdi.mainGroup).maxCount(64).food( new FoodComponent.Builder().alwaysEdible().saturationModifier(0.5f).hunger(3).build()));
    public static final Item CHOCOLATE_IN_PAPER = new Item(new FabricItemSettings().group(Mdi.mainGroup).maxCount(64).food( new FoodComponent.Builder().alwaysEdible().saturationModifier(0.5f).hunger(3).build()));

    @Override
    public void onInitialize() {
        //Block items
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_block"), DIOLITE_BLOCK);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot_block"), DIOLITE_INGOT_BLOCK);
        Registry.register(Registry.ITEM, Mdi.idOf("onium"), ONIUM);
        Registry.register(Registry.ITEM, Mdi.idOf("glowing_mushroom"), GLOWING_MUSHROOM);
        Registry.register(Registry.ITEM, Mdi.idOf("glowing_mushroom_stem"), GLOWING_MUSHROOM_STEM);
        Registry.register(Registry.ITEM, Mdi.idOf("glowing_mushroom_block"), GLOWING_MUSHROOM_BLOCK);
        Registry.register(Registry.ITEM, Mdi.idOf("end_torch"), END_TORCH);
        Registry.register(Registry.ITEM, Mdi.idOf("end_lantern"), END_LANTERN);
        //Resources
        Registry.register(Registry.ITEM, Mdi.idOf("diolite"), RAW_DIOLITE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot"), DIOLITE_INGOT);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_ingot_charge"), DIOLITE_INGOT_CHARGED);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_shard"), DIOLITE_SHARD);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_nugget"), DIOLITE_NUGGET);
        //Fruits
        Registry.register(Registry.ITEM, Mdi.idOf("life_fruit"), LIFE_FRUIT);
        Registry.register(Registry.ITEM, Mdi.idOf("chocolate"), CHOCOLATE);
        Registry.register(Registry.ITEM, Mdi.idOf("chocolate_in_paper"), CHOCOLATE_IN_PAPER);
        //Weapons & armour
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_boots"), DIOLITE_BOOTS);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_leggings"), DIOLITE_LEGGINGS);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_chestplate"), DIOLITE_CHESTPLATE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_armor_helmet"), DIOLITE_HELMET);

        Registry.register(Registry.ITEM, Mdi.idOf("diolite_sword"), DIOLITE_SWORD);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_shovel"), DIOLITE_SHOVEL);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_pickaxe"), DIOLITE_PICKAXE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_axe"), DIOLITE_AXE);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_hoe"), DIOLITE_HOE);
        //Hooks
        Registry.register(Registry.ITEM, Mdi.idOf("wooden_hook"), WOODEN_HOOK);
        Registry.register(Registry.ITEM, Mdi.idOf("iron_hook"), IRON_HOOK);
        Registry.register(Registry.ITEM, Mdi.idOf("gold_hook"), GOLD_HOOK);
        Registry.register(Registry.ITEM, Mdi.idOf("diamond_hook"), DIAMOND_HOOK);
        Registry.register(Registry.ITEM, Mdi.idOf("netherite_hook"), NETHERITE_HOOK);
        Registry.register(Registry.ITEM, Mdi.idOf("diolite_hook"), DIOLITE_HOOK);
    }
}
