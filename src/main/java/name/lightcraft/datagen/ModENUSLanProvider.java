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

        translationBuilder.add("item.light_craft.handheld_prospector.found_ore_message", "Prospector: Found ");
        translationBuilder.add("item.light_craft.handheld_prospector.not_found_message", "Prospector: No Ore Found");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip","\u00a77A useful tool used to look for ores\u00a7r");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip.not_shift", "Press \u00a76SHIFT\u00a7r for more information");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip.shift", "After being used on a \u00a76block\u00a7r, it will be detected from \u00a7924\u00a7r to \u00a7948\u00a7r blocks down, returning only the \u00a77first\u00a7r mineral");
        translationBuilder.add("item.light_craft.hot_milk_bottle.tip", "An unremarkable drink, the only difference from milk seems to be only the temperature... Right?");
        translationBuilder.add("item.light_craft.hot_milk_bottle.use_tip", "After drinking, restore a certain amount of nutrition (saturation) , and \u00a76clear all negative effects\u00a7r");

    }
}
