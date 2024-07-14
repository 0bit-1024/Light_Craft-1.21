package name.lightcraft.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class HandHeldProspector extends Item {
    public HandHeldProspector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        // Judgment between client and server
        // 客户（服务）端的判断
        if (!world.isClient) {
            int foundHeight = blockPos.getY();
            boolean foundBlock = false;
            /*
            Found an ore through looping from
            the current position of the block that the player's cursor is pointing at to down for 48 blocks
            */
            for (int i = blockPos.getY(); i >= blockPos.getY()-48; i--){
                BlockState blockState = world.getBlockState(
                        new BlockPos(blockPos.getX(), foundHeight, blockPos.getZ()));
                if (isOre(blockState)){
                    foundBlock = true;
                    player.sendMessage(Text.of(Text.of(Text.translatable("item.light_craft.handheld_prospector.found_ore_message").formatted(Formatting.GRAY)).getString()
                            +blockState.getBlock().getName().getString()), false);
                    break;
                } else if (isBlockOrLiquid(blockState)) {
                    i -= 1;
                }
                foundHeight -= 1;
            }
            if (!foundBlock){
                player.sendMessage(Text.of(Text.translatable("item.light_craft.handheld_prospector.not_found_message").formatted(Formatting.GRAY)), false);
            }
        }
        //reduce the durability of the item
        //减少物品的耐久度
        context.getStack().damage(1, player, EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.of(Text.translatable("item.light_craft.handheld_prospector.tooltip")));
        tooltip.add(Text.of(""));
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.of(Text.translatable("item.light_craft.handheld_prospector.tooltip.not_shift")));
        }
        else {
            tooltip.add(Text.of(Text.translatable("item.light_craft.handheld_prospector.tooltip.shift")));
        }
        tooltip.add(Text.of(""));
    }

    private boolean isOre(BlockState blockState) {
        return blockState.getBlock().getTranslationKey().contains("ore");
    }

    private boolean isBlockOrLiquid(BlockState blockState) { return !blockState.isAir(); }
}
