package name.lightcraft.block;

import name.lightcraft.LightCraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ZINC_ORE = register("zinc_ore", new Block(AbstractBlock.Settings.create().strength(3.0F,3.0f).requiresTool()));
    public static final Block DEEPSLATE_ZINC_ORE = register("deepslate_zinc_ore", new Block(AbstractBlock.Settings.create().strength(4.0F,4.0f).requiresTool()));
    public static final Block ZINC_BLOCK = register("zinc_block", new Block(AbstractBlock.Settings.create().strength(4.5F,4.5f).requiresTool()));

    public static void registerBlockItems(String id, Block block) {
        BlockItem item = Registry.register(Registries.ITEM, Identifier.of(LightCraft.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LightCraft.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        LightCraft.LOGGER.info("Registering Mod Blocks");
    }
}
