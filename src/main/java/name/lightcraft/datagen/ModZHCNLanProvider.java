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
        translationBuilder.add(ModBlocks.SPHALERITE_ORE, "闪锌矿");
        translationBuilder.add(ModBlocks.ZINC_BLOCK, "锌块");

        translationBuilder.add("item.light_craft.handheld_prospector.found_ore_message", "\u00a77探矿器：发现 \u00a7r");
        translationBuilder.add("item.light_craft.handheld_prospector.not_found_message", "\u00a77探矿器：没有矿物发现\u00a7r");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip","\u00a77可用于寻找矿物的便携工具\u00a77");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip.not_shift", "按下 \u00a76SHIFT\u00a7r 以查看更多的信息");
        translationBuilder.add("item.light_craft.handheld_prospector.tooltip.shift", "在\u00a76方块\u00a7r上使用后，由上探测至\u00a7924\u00a7r到\u00a7948\u00a7r格下的方块，且只返回\u00a76第一个\u00a7r矿物");
        translationBuilder.add("item.light_craft.hot_milk_bottle.tip", "一个平平无奇的饮品，与牛奶唯一的区别似乎只有温度...吧?");
        translationBuilder.add("item.light_craft.hot_milk_bottle.use_tip", "在饮用后回复一定的饱食（饱和）度，并\u00a76清除所有的负面效果\u00a7r");

    }
}
