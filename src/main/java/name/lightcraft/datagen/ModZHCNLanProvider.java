package name.lightcraft.datagen;

import name.lightcraft.block.ModBlocks;
import name.lightcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {
    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.light_craft.natural", "光艺：自然方块");
        translationBuilder.add("itemGroup.light_craft.building", "光艺：建筑方块");
        translationBuilder.add("itemGroup.light_craft.ingredients", "光艺：原材料");
        translationBuilder.add("itemGroup.light_craft.food_and_drinks", "光艺：食物与饮品");
        translationBuilder.add("itemGroup.light_craft.tools", "光艺：工具与实用物品");

        translationBuilder.add(ModItems.HANDHELD_PROSPECTOR, "手持探矿器");
        translationBuilder.add(ModItems.CYLINDRICAL_GLASS_BOTTLE, "柱形玻璃瓶");
        translationBuilder.add(ModItems.HOT_MILK_BOTTLE, "热奶瓶");
        translationBuilder.add(ModItems.RAW_ZINC, "粗锌矿");
        translationBuilder.add(ModItems.ZINC_INGOT, "锌锭");

        translationBuilder.add(ModBlocks.ZINC_ORE, "锌矿石");
        translationBuilder.add(ModBlocks.DEEPSLATE_ZINC_ORE, "深层锌矿石");
        translationBuilder.add(ModBlocks.ZINC_BLOCK, "锌块");
    }
}
