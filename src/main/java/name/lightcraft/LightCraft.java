package name.lightcraft;

import name.lightcraft.block.ModBlocks;
import name.lightcraft.item.ModItemGroups;
import name.lightcraft.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightCraft implements ModInitializer {
	public static final String MOD_ID = "light_craft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		LightCraft.LOGGER.info("Hello Fabric world!");
	}
}