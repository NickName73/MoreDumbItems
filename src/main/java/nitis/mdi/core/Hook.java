package nitis.mdi.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Hook extends PickaxeItem {
    protected ArrayList<Tag<Block>> effectiveBlocks = new ArrayList<>();
    public static ArrayList<Tag<Block>> hookEffectiveBlocks;
    public Hook(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, ArrayList<Tag<Block>> effectiveBlocks, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.effectiveBlocks = effectiveBlocks;
    }
    protected Hook(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, (LivingEntity)attacker, (Consumer<LivingEntity>)((e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        }));
        return true;
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        boolean contains = false;
        for (Tag<Block> tag : effectiveBlocks) {
            if(tag.contains(state.getBlock())) {
                contains = true;
                break;
            }
        }
        return contains ? this.miningSpeed : 0.75F;
    }

    static {
        hookEffectiveBlocks = new ArrayList<Tag<Block>>();
        hookEffectiveBlocks.add(BlockTags.DRAGON_IMMUNE);
        hookEffectiveBlocks.add(BlockTags.WITHER_IMMUNE);
        hookEffectiveBlocks.add(BlockTags.PICKAXE_MINEABLE);
    }
}
