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
                    return "insulator"; }});
    // that was lowkey fire, i think now im done with the my first crafting block

    public static final RecipeSerializer<PressureRecipe> PRESSURE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Electric.MOD_ID, "pressure"),
            new PressureRecipe.Serializer());
    public static final RecipeType<PressureRecipe> PRESSURE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Electric.MOD_ID, "pressure"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "pressure";}});

    // so now IM DONE WITH THIS TRASHHH bruh for 2nd time
    public static final RecipeSerializer<CoilerRecipe> COILER_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Electric.MOD_ID, "coiler"),
            new CoilerRecipe.Serializer());
    public static final RecipeType<CoilerRecipe> COILER_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Electric.MOD_ID, "coiler"), new RecipeType<>() {
                @Override
                public String toString() {
                    return "coiler";}});

    public static void registerRecipe(){
        Electric.LOGGER.info("Registering recipes F-O-R <3" + Electric.MOD_ID);
    }

}
