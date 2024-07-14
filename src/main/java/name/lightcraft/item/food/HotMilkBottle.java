package name.lightcraft.item.food;

import name.lightcraft.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

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

        if (!world.isClient) {
            //remove all negative effects
            //消除所有负面影响
            removeAllNegativeEffects(user);
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.CYLINDRICAL_GLASS_BOTTLE);
        } else {
            if (user instanceof PlayerEntity playerEntity) {
                if (!playerEntity.isInCreativeMode()) {
                    ItemStack itemStack = new ItemStack(ModItems.CYLINDRICAL_GLASS_BOTTLE);
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }

            return stack;
        }
    }

    private void removeAllNegativeEffects(LivingEntity entity) {
        entity.removeStatusEffect(StatusEffects.SLOWNESS);
        entity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
        entity.removeStatusEffect(StatusEffects.INSTANT_DAMAGE);
        entity.removeStatusEffect(StatusEffects.NAUSEA);
        entity.removeStatusEffect(StatusEffects.BLINDNESS);
        entity.removeStatusEffect(StatusEffects.HUNGER);
        entity.removeStatusEffect(StatusEffects.WEAKNESS);
        entity.removeStatusEffect(StatusEffects.POISON);
        entity.removeStatusEffect(StatusEffects.WITHER);
        entity.removeStatusEffect(StatusEffects.LEVITATION);
        entity.removeStatusEffect(StatusEffects.UNLUCK);
        entity.removeStatusEffect(StatusEffects.BAD_OMEN);
        entity.removeStatusEffect(StatusEffects.DARKNESS);
        entity.removeStatusEffect(StatusEffects.WIND_CHARGED);
        entity.removeStatusEffect(StatusEffects.WEAVING);
        entity.removeStatusEffect(StatusEffects.OOZING);
        entity.removeStatusEffect(StatusEffects.INFESTED);
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

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.of(Text.translatable("item.light_craft.hot_milk_bottle.tip").formatted(Formatting.GRAY)));
        tooltip.add(Text.of(" "));
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.of(Text.translatable("item.light_craft.hot_milk_bottle.use_tip")));
            tooltip.add(Text.of(""));
        }
    }
}