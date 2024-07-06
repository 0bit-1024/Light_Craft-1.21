package name.lightcraft.datagen;


import name.lightcraft.LightCraft;
import name.lightcraft.block.ModBlocks;
import name.lightcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;

import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    public static final List<ItemConvertible> ZINC_INGOT = List.of(ModBlocks.ZINC_ORE, ModBlocks.DEEPSLATE_ZINC_ORE, ModItems.RAW_ZINC);

    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
         offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ZINC_INGOT,
                 RecipeCategory.BUILDING_BLOCKS, ModBlocks.ZINC_BLOCK);

        offerSmelting(exporter, ZINC_INGOT, RecipeCategory.MISC, ModItems.ZINC_INGOT, 0.7f, 240, "zinc");
        offerBlasting(exporter, ZINC_INGOT, RecipeCategory.MISC, ModItems.ZINC_INGOT, 0.7f, 120, "zinc");

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Blocks.GLASS), RecipeCategory.MISC, ModItems.CYLINDRICAL_GLASS_BOTTLE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ZINC_ORE, 1)
                .pattern("#~#")
                .pattern("~#~")
                .pattern("#~#")
                .input('#', Blocks.STONE)
                .input('~', ModItems.RAW_ZINC)
                .criterion("has_raw_zinc", RecipeProvider.conditionsFromItem(ModItems.RAW_ZINC))
                .criterion("has_stone", RecipeProvider.conditionsFromItem(Blocks.STONE))
                .offerTo(exporter, Identifier.of(LightCraft.MOD_ID, "stone_to_zinc_ore"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEEPSLATE_ZINC_ORE, 1)
                .pattern("#~#")
                .pattern("~#~")
                .pattern("#~#")
                .input('#', Blocks.DEEPSLATE)
                .input('~', ModItems.RAW_ZINC)
                .criterion("has_raw_zinc", RecipeProvider.conditionsFromItem(ModItems.RAW_ZINC))
                .criterion("has_deepslate", RecipeProvider.conditionsFromItem(Blocks.DEEPSLATE))
                .offerTo(exporter, Identifier.of(LightCraft.MOD_ID, "deepslate_to_deepslate_zinc_ore"));
    }
}
