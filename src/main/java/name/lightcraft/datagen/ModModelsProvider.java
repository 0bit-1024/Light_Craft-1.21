package name.lightcraft.datagen;

import name.lightcraft.block.ModBlocks;
import name.lightcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZINC_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZINC_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPHALERITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZINC_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Why can't it use the true "register" ?
//        itemModelGenerator.register(ModItems.RAW_ZINC, Models.GENERATED);

    }
}