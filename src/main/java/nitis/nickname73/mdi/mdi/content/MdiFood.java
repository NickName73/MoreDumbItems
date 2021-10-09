package nitis.nickname73.mdi.mdi.content;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nitis.nickname73.mdi.mdi.Mdi;
import org.jetbrains.annotations.NotNull;
import java.util.*;

public class MdiFood implements ModInitializer {
    public static final Item CHOCOLATE = new Item(new FabricItemSettings()
            .group(Mdi.mdiGroup)
            .maxCount(64)
            .food( new FoodComponent.Builder().alwaysEdible().saturationModifier(0.5f).hunger(3).build()));
    public static final Item CHOCOLATE_IN_PAPER = new Item(new FabricItemSettings()
            .group(Mdi.mdiGroup)
            .maxCount(64)
            .food( new FoodComponent.Builder().alwaysEdible().saturationModifier(0.5f).hunger(3).build()));
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(Mdi.modID, "chocolate"), CHOCOLATE);
        Registry.register(Registry.ITEM, new Identifier(Mdi.modID, "chocolate_in_paper"), CHOCOLATE_IN_PAPER);
    }
}
