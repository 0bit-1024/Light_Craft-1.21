package name.lightcraft.item;

import name.lightcraft.LightCraft;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    //create item groups
    //创建创造模式物品栏
//    public static final ItemGroup LIGHT_CRAFT_TOOLS  = Registry.register(Registries.ITEM_GROUP,
//            Identifier.of(LightCraft.MOD_ID, "light_craft_tools"), ItemGroup.create(null, -1).
//                    displayName(Text.translatable("itemGroup.light_craft.tools")).
//                    icon(() -> new ItemStack(ModItems.Prospector)).
//                    entries((displayContext, entries) -> {
//                        //Add items
//                        //添加物品
//                        entries.add(ModItems.Prospector);
//                    }).build());
    //Also a bug !

    public static final ItemGroup LIGHT_CRAFT_FOOD_AND_DRINK  = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LightCraft.MOD_ID, "light_craft_tools"), ItemGroup.create(null, -1).
                    displayName(Text.translatable("itemGroup.light_craft.food_and_drinks")).
                    icon(() -> new ItemStack(ModItems.Hot_Milk_Bottle)).
                    entries((displayContext, entries) -> {
                        //Add items
                        //添加物品
                        entries.add(ModItems.Hot_Milk_Bottle);
                    }).build());

    public static void registerItemGroups() {
        LightCraft.LOGGER.info("Registering Item Groups");
    }
}
