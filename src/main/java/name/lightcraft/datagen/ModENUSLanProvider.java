package name.lightcraft.datagen;

import name.lightcraft.item.ModItems;
import name.lightcraft.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.light_craft.natural", "Light Craft: Natural Blocks");
        translationBuilder.add("itemGroup.light_craft.building", "Light Craft: Building Blocks");
        translationBuilder.add("itemGroup.light_craft.ingredients", "Light Craft: Ingredients");
        translationBuilder.add("itemGroup.light_craft.food_and_drinks", "Light Craft: Food and Drinks");
        translationBuilder.add("itemGroup.light_craft.tools", "Light Craft: Tools");

        translationBuilder.add(ModItems.HANDHELD_PROSPECTOR, "Handheld Prospector");
        translationBuilder.add(ModItems.CYLINDRICAL_GLASS_BOTTLE, "Cylindrical Glass Bottle");
        translationBuilder.add(ModItems.HOT_MILK_BOTTLE, "Hot Milk Bottle");
        translationBuilder.add(ModItems.RAW_ZINC, "Raw Zinc");
        translationBuilder.add(ModItems.ZINC_INGOT, "Zinc Ingot");

        translationBuilder.add(ModBlocks.ZINC_ORE, "Zinc Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_ZINC_ORE, "Deepslate Zinc Ore");
        translationBuilder.add(ModBlocks.SPHALERITE_ORE, "Sphalerite Ore");
        translationBuilder.add(ModBlocks.ZINC_BLOCK, "Zinc Block");

    }
}
