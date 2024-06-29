package name.lightcraft.item;

import name.lightcraft.LightCraft;
import name.lightcraft.item.custom.HandHeldProspector;
import name.lightcraft.item.food.HotMilkBottle;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item GlASS_BOTTLE;

    //create mod items
    //创建模组物品
    public static final Item Prospector = registerItems("handheld_prospector", new HandHeldProspector(new Item.Settings().maxCount(1).maxDamage(64)));
    public static final Item Hot_Milk_Bottle = registerItems("hot_milk_bottle", new HotMilkBottle(new Item.Settings().recipeRemainder(GlASS_BOTTLE).food(FoodComponents.HONEY_BOTTLE).maxCount(16)));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LightCraft.MOD_ID, id), item);
    }

    //Has some problems
    public static void addItemToIG(FabricItemGroupEntries entries){
        entries.add(Prospector);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToIG);
        LightCraft.LOGGER.info("Registering Mod Items");
    }
}
