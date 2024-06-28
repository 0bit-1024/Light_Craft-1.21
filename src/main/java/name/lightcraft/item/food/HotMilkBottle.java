package name.lightcraft.item.food;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

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
            if (user instanceof PlayerEntity playerEntity) {
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
        Set<StatusEffectInstance> negativeEffectsToRemove = new HashSet<>();
        //get all negative effects
        //获取所有负面影响
        for (StatusEffectInstance effect : entity.getStatusEffects()) {
            if (isNegativeEffect(effect.getEffectType())) {
                negativeEffectsToRemove.add(effect);
            }
        }
        //remove all negative effects
        //消除所有负面影响
        for (StatusEffectInstance effect: negativeEffectsToRemove) {
            entity.removeStatusEffect(effect.getEffectType());
        }
    }

    private boolean isNegativeEffect(RegistryEntry<StatusEffect> effectType) {
        return effectType == StatusEffects.SLOWNESS
                || effectType == StatusEffects.MINING_FATIGUE
                || effectType == StatusEffects.INSTANT_DAMAGE
                || effectType == StatusEffects.NAUSEA
                || effectType == StatusEffects.BLINDNESS
                || effectType == StatusEffects.HUNGER
                || effectType == StatusEffects.WEAKNESS
                || effectType == StatusEffects.POISON
                || effectType == StatusEffects.WITHER
                || effectType == StatusEffects.LEVITATION
                || effectType == StatusEffects.UNLUCK
                || effectType == StatusEffects.DARKNESS
                || effectType == StatusEffects.WIND_CHARGED
                || effectType == StatusEffects.WEAVING
                || effectType == StatusEffects.OOZING
                || effectType == StatusEffects.INFESTED;
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