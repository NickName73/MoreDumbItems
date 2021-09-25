package nitis.nickname73.mdi.mdi;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.BlockState;
import net.minecraft.client.WindowEventHandler;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import nitis.nickname73.mdi.mdi.content.Commands;
import nitis.nickname73.mdi.mdi.content.Diolite;
import nitis.nickname73.mdi.mdi.content.MdiEffects;
import nitis.nickname73.mdi.mdi.content.RedstoneThings;

import java.util.EventListener;

public class Mdi implements ModInitializer {
    public static final String modID = "mdi";
    public static final ItemGroup mdiGroup = FabricItemGroupBuilder.create(
            new Identifier(modID,"default"))
            .icon(() -> new ItemStack(Diolite.RAW))
            //.appendItems(stacks -> {
            //})
            .build();
    public static final ItemGroup mdiWeaponGroup = FabricItemGroupBuilder.create(
                    new Identifier(modID,"weapon"))
            .icon(() -> new ItemStack(Diolite.INGOT))
            //.appendItems(stacks -> {
            //})
            .build();

    @Override
    public void onInitialize() {
        new Diolite().onInitialize();
        new RedstoneThings().onInitialize();
        new MdiEffects().onInitialize();
        new Commands().onInitialize();
    }
}
