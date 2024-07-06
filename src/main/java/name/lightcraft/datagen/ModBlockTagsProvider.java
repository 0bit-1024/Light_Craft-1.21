package name.lightcraft.datagen;

import name.lightcraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // 添加方块标签：使用镐子开采的方块
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ZINC_ORE)
                .add(ModBlocks.DEEPSLATE_ZINC_ORE)
                .add(ModBlocks.ZINC_BLOCK);

        // 添加方块标签：开采工具至少为铁制工具
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ZINC_ORE)
                .add(ModBlocks.DEEPSLATE_ZINC_ORE)
                .add(ModBlocks.ZINC_BLOCK);
    }
}
