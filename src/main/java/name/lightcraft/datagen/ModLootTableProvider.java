package name.lightcraft.datagen;

import name.lightcraft.block.ModBlocks;
import name.lightcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //此处添加掉落物配置
        addDrop(ModBlocks.ZINC_ORE, oreDrops(ModBlocks.ZINC_ORE, ModItems.RAW_ZINC));
        addDrop(ModBlocks.DEEPSLATE_ZINC_ORE, oreDrops(ModBlocks.DEEPSLATE_ZINC_ORE, ModItems.RAW_ZINC));
        addDrop(ModBlocks.ZINC_BLOCK, drops(ModBlocks.ZINC_BLOCK));

    }

    // 自定义矿石掉落的凋落物，掉落数量区间
    private LootTable.Builder CustomOreDrops(Block drop, Item dropItem, float min_count, float max_count) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min_count, max_count)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
