package name.lightcraft.item;

import name.lightcraft.LightCraft;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    //create mod items
    public static final Item Prospector = registerItems("prospector", new Item(new Item.Settings().maxCount(1)));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LightCraft.MOD_ID, id), item);
    }

    public static void registerModItems() {
        LightCraft.LOGGER.info("Registering Mod Items for " + LightCraft.MOD_ID);
    }
}
