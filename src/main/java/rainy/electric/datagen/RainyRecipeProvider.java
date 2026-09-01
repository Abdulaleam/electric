package rainy.electric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import rainy.electric.block.RainyBlocks;
import rainy.electric.item.RainyItems;

import java.util.concurrent.CompletableFuture;

public class RainyRecipeProvider extends FabricRecipeProvider {
    public RainyRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.ZINC_DUST)
                .pattern("ZZ")
                .pattern("ZZ")
                .input('Z', RainyItems.ZINC_PILE)
                .criterion(hasItem(RainyItems.ZINC_PILE), conditionsFromItem(RainyItems.ZINC_PILE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.COPPER_WIRE)
                .pattern("ZZZ")
                .input('Z', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.ZINC_WIRE)
                .pattern("ZZZ")
                .input('Z', RainyItems.ZINC_INGOT)
                .criterion(hasItem(RainyItems.ZINC_INGOT), conditionsFromItem(RainyItems.ZINC_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.GOLD_WIRE)
                .pattern("ZZZ")
                .input('Z', Items.GOLD_INGOT)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyBlocks.INSULATOR)
                .pattern("YYY")
                .pattern("NXN")
                .pattern("ZZZ")
                .input('X', RainyItems.EMPTY_BATTERY)
                .input('Z', RainyItems.GOLD_WIRE)
                .input('N', Items.REDSTONE)
                .input('Y', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.EMPTY_BATTERY)
                .pattern("YYY")
                .pattern("XZX")
                .pattern("NNN")
                .input('X', Items.REDSTONE_BLOCK)
                .input('Z', RainyItems.COPPER_WIRE)
                .input('N', Items.GOLD_INGOT)
                .input('Y', Items.STONE_BRICKS)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.CIRCUIT)
                .pattern("XXX")
                .pattern("YRY")
                .pattern("XXX")
                .input('X', RainyItems.COPPER_INSULATED_WIRE)
                .input('Y', Items.REDSTONE)
                .input('R', RainyItems.ZINC_INGOT)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.UPGRADED_CIRCUIT)
                .pattern("RRR")
                .pattern("FXF")
                .pattern("RRR")
                .input('R', Items.OBSIDIAN)
                .input('F', Items.DIAMOND)
                .input('X', RainyItems.CIRCUIT)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.ZINC_INGOT)
                .pattern("RRR")
                .pattern("RXR")
                .pattern("RRR")
                .input('R', Items.GOLD_NUGGET)
                .input('X', RainyItems.ZINC_DUST)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.CHARGED_BATTERY)
                .pattern("RRR")
                .pattern("RXR")
                .pattern("RRR")
                .input('R', Items.REDSTONE)
                .input('X', RainyItems.CHARGED_BATTERY)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.ELECTRIC_SWORD)
                .pattern("ZZZ")
                .pattern("FXF")
                .pattern("YYY")
                .input('X', RainyItems.UPGRADED_CIRCUIT)
                .input('Z', RainyItems.INSULATED_ZINC_WIRE)
                .input('Y', RainyItems.GOLD_COIL)
                .input('F', RainyItems.CHARGED_BATTERY)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);








    }
}
