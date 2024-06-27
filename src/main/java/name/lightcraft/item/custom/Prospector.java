package name.lightcraft.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Prospector extends Item {
    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        // Judgment between client and server
        if (!world.isClient) {
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            /* Found the ore through looping from the bottom of the world to
                the current position of the block that the player's cursor is pointing at */
            for (int i = blockPos.getY(); i >= blockPos.getY()-48; i--){
                BlockState blockState = context.getWorld().getBlockState(
                        new BlockPos(blockPos.getX(), i, blockPos.getZ()));
                if (isOre(blockState)){
                    foundBlock = true;
                    player.sendMessage(Text.literal("Prospector: Found " + blockState.getBlock().getName().getString()
                            + " at (" + blockPos.getX() + "," + i + "," + blockPos.getZ() + ") !"), false);
                    break;
                }
            }
            if (!foundBlock){
                player.sendMessage(Text.literal("Prospector: No ore found !"), false);
            }
        }
        //context.getStack().damage(-1, context.getPlayer(), playerEntity -> playerEntity.));

        return ActionResult.SUCCESS;
    }

    private boolean isOre(BlockState blockState) {
        return blockState.getBlock().getTranslationKey().contains("ore");
    }
}
