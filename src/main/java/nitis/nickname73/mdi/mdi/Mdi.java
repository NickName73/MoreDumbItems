package nitis.nickname73.mdi.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import nitis.nickname73.mdi.mdi.client.MdiConfig;
import nitis.nickname73.mdi.mdi.content.*;

public class Mdi implements ModInitializer {
    public static final String modID = "mdi";
    public static final ItemGroup mdiGroup = FabricItemGroupBuilder.create(
            new Identifier(modID,"default"))
            .icon(() -> new ItemStack(Diolite.RAW))
            .build();
    public static final ItemGroup mdiWeaponGroup = FabricItemGroupBuilder.create(
                    new Identifier(modID,"weapon"))
            .icon(() -> new ItemStack(Diolite.INGOT))
            .build();

    @Override
    public void onInitialize() {
        new Diolite().onInitialize(); // Diolite items
        new MdiFood().onInitialize(); // Foods
        new RedstoneThings().onInitialize(); // Redstone items & blocks (Pulsar)
        new MdiEffects().onInitialize(); // Effects
        new MdiPotions().onInitialize(); // Effect bottles
        new Commands().onInitialize(); // Commands
    }
}
