package name.lightcraft.item;

import name.lightcraft.LightCraft;
import name.lightcraft.item.food.HotMilkBottle;
import name.lightcraft.item.custom.Prospector;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item GlASS_BOTTLE;

    //create mod items
    public static final Item Prospector = registerItems("prospector", new Prospector(new Item.Settings().maxCount(1).maxDamage(63)));

    public static final Item Hot_Milk_Bottle = registerItems("hot_milk_bottle", new HotMilkBottle(new Item.Settings().recipeRemainder(GlASS_BOTTLE).food(FoodComponents.HONEY_BOTTLE).maxCount(16)));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LightCraft.MOD_ID, id), item);
    }

    public static void registerModItems() {
        LightCraft.LOGGER.info("Registering Mod Items for " + LightCraft.MOD_ID);
    }
}
