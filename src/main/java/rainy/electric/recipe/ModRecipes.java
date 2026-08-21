package rainy.electric.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;

public class ModRecipes {

    public static final RecipeSerializer<InsulatorRecipe> INSULATOR_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Electric.MOD_ID, "insulator"),
            new InsulatorRecipe.Serializer());
    public static final RecipeType<InsulatorRecipe> INSULATOR_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Electric.MOD_ID, "insulator"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "insulator";
                }
            }
    );
    public static void registerRecipe(){}

}
