package name.lightcraft.item;

import name.lightcraft.LightCraft;
import name.lightcraft.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    //create item groups
    //创建创造模式物品栏
    public static final ItemGroup LIGHT_CRAFT_NATURAL  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_natural"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.natural")).
                    icon(() -> new ItemStack(ModBlocks.ZINC_ORE)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModBlocks.ZINC_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ZINC_ORE);
                    }).build());

    public static final ItemGroup LIGHT_CRAFT_BUILDING  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_building"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.building")).
                    icon(() -> new ItemStack(ModBlocks.ZINC_BLOCK)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModBlocks.ZINC_BLOCK);
                    }).build());

    public static final ItemGroup LIGHT_CRAFT_INGREDIENTS  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_ingredients"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.ingredients")).
                    icon(() -> new ItemStack(ModItems.ZINC_INGOT)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModItems.CYLINDRICAL_GLASS_BOTTLE);
                        entries.add(ModItems.RAW_ZINC);
                        entries.add(ModItems.ZINC_INGOT);
                    }).build());

    public static final ItemGroup LIGHT_CRAFT_FOOD_AND_DRINKS  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_food_and_drinks"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.food_and_drinks")).
                    icon(() -> new ItemStack(ModItems.HOT_MILK_BOTTLE)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModItems.HOT_MILK_BOTTLE);
                    }).build());

    public static final ItemGroup LIGHT_CRAFT_TOOLS  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_tools"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.tools")).
                    icon(() -> new ItemStack(ModItems.HANDHELD_PROSPECTOR)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModItems.HANDHELD_PROSPECTOR);
                    }).build());


    public static void registerItemGroups() {
        LightCraft.LOGGER.info("Registering Item Groups");
    }
}
