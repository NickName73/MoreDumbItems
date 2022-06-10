package nitis.mdi.core;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StatusEffectFoodItem extends Item {
    protected StatusEffectInstance effect;
    public StatusEffectFoodItem(Settings settings, FoodComponent.Builder foodBuilder, StatusEffectInstance effect) {
        super(settings.food(foodBuilder.statusEffect(effect, 1f).build()));
        this.effect = effect;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.hasStatusEffect(effect.getEffectType())) return TypedActionResult.fail(user.getStackInHand(hand));
        if (this.isFood()) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            } else {
                return TypedActionResult.fail(itemStack);
            }
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }
}
