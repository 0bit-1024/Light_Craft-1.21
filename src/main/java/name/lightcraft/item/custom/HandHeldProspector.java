package name.lightcraft.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HandHeldProspector extends Item {
    public HandHeldProspector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        // Judgment between client and server
        // 客户（服务）端的判断
        if (!world.isClient) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            int foundHeight = blockPos.getY();
            boolean foundBlock = false;

            /*
            Found an ore through looping from
            the current position of the block that the player's cursor is pointing at to down for 48 blocks
            */
            for (int i = blockPos.getY(); i >= blockPos.getY()-48; i--){
                BlockState blockState = context.getWorld().getBlockState(
                        new BlockPos(blockPos.getX(), foundHeight, blockPos.getZ()));
                if (isOre(blockState)){
                    foundBlock = true;
                    player.sendMessage(Text.literal("Prospector: Found " + blockState.getBlock().getName().getString()
                            + " at (" + blockPos.getX() + "," + foundHeight + "," + blockPos.getZ() + ") !"), false);
                    break;
                } else if (isBlockOrLiquid(blockState)) {
                    i -= 1;
                }
                foundHeight -= 1;
            }
            if (!foundBlock){
                player.sendMessage(Text.literal("Prospector: No ore found !"), false);
            }
        }
        //reduce the durability of the item
        //减少物品的耐久度
        context.getStack().damage(1, context.getPlayer(), context.getPlayer().getPreferredEquipmentSlot(context.getStack()));

        return ActionResult.SUCCESS;
    }

    private boolean isOre(BlockState blockState) {
        return blockState.getBlock().getTranslationKey().contains("ore");
    }

    private boolean isBlockOrLiquid(BlockState blockState) { return !blockState.isAir(); }
}
