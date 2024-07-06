package name.lightcraft.item;

import name.lightcraft.LightCraft;
import name.lightcraft.item.custom.HandHeldProspector;
import name.lightcraft.item.food.HotMilkBottle;
import name.lightcraft.item.food.ModFoodComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //create mod items
    //创建模组物品
    public static final Item HANDHELD_PROSPECTOR = registerItems("handheld_prospector", new HandHeldProspector(new Item.Settings().maxCount(1).maxDamage(64)));
    public static final Item CYLINDRICAL_GLASS_BOTTLE = registerItems("cylindrical_glass_bottle", new Item(new Item.Settings().maxCount(16)));
    public static final Item HOT_MILK_BOTTLE = registerItems("hot_milk_bottle", new HotMilkBottle(new Item.Settings().recipeRemainder(CYLINDRICAL_GLASS_BOTTLE).food(ModFoodComponents.HOT_MILK_BOTTLE).maxCount(16)));
    public static final Item RAW_ZINC = registerItems("raw_zinc", new Item(new Item.Settings()));
    public static final Item ZINC_INGOT = registerItems("zinc_ingot", new Item(new Item.Settings()));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LightCraft.MOD_ID, id), item);
    }

    public static void registerModItems() {
        LightCraft.LOGGER.info("Registering Mod Items");
    }
}
