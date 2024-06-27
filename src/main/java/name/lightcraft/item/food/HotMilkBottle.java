package name.lightcraft.item.food;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class HotMilkBottle extends Item {
    private static final int MAX_USE_TIME = 40;
    public HotMilkBottle(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user){
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        //remove all negative effects
        if (!world.isClient) {
            removeAllNegativeEffects(user);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (user instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity)user;
                if (!playerEntity.isInCreativeMode()) {
                    ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }

            return stack;
        }
    }

    private void removeAllNegativeEffects(LivingEntity entity) {
        for (StatusEffectInstance effect : entity.getStatusEffects()) {
            //Table all the negative effects
            if (effect.getEffectType() == StatusEffects.SLOWNESS
                    || effect.getEffectType() == StatusEffects.MINING_FATIGUE
                    || effect.getEffectType() == StatusEffects.INSTANT_DAMAGE
                    || effect.getEffectType() == StatusEffects.NAUSEA
                    || effect.getEffectType() == StatusEffects.BLINDNESS
                    || effect.getEffectType() == StatusEffects.HUNGER
                    || effect.getEffectType() == StatusEffects.WEAKNESS
                    || effect.getEffectType() == StatusEffects.POISON
                    || effect.getEffectType() == StatusEffects.WITHER
                    || effect.getEffectType() == StatusEffects.LEVITATION
                    || effect.getEffectType() == StatusEffects.UNLUCK
                    || effect.getEffectType() == StatusEffects.DARKNESS
                    || effect.getEffectType() == StatusEffects.WIND_CHARGED
                    || effect.getEffectType() == StatusEffects.WEAVING
                    || effect.getEffectType() == StatusEffects.OOZING
                    || effect.getEffectType() == StatusEffects.INFESTED
            ) {
                //Remove the  negative effect
                entity.removeStatusEffect(effect.getEffectType());
            }
        }
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 40;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
