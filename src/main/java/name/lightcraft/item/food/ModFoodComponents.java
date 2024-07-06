package name.lightcraft.item.food;

import name.lightcraft.item.ModItems;
import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent HOT_MILK_BOTTLE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.2f)
            .usingConvertsTo(ModItems.CYLINDRICAL_GLASS_BOTTLE)
            .alwaysEdible().build();
}
