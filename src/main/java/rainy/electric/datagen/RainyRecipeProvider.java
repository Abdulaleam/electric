package rainy.electric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.MARROW_DUST)
                .pattern("ZZ")
                .pattern("ZZ")
                .input('Z', RainyItems.MARROW_HEAP)
                .criterion(hasItem(RainyItems.MARROW_HEAP), conditionsFromItem(RainyItems.MARROW_HEAP))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.COPPER_WIRE)
                .pattern("ZZZ")
                .input('Z', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.ZINC_WIRE)
                .pattern("ZZZ")
                .input('Z', RainyItems.MARROW_INGOT)
                .criterion(hasItem(RainyItems.MARROW_INGOT), conditionsFromItem(RainyItems.MARROW_INGOT))
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
                .input('X', RainyItems.BEATING_HEART)
                .input('Z', RainyItems.GOLD_WIRE)
                .input('N', Items.REDSTONE)
                .input('Y', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RainyItems.DORMANT_HEART)
                .pattern("YYY")
                .pattern("XZX")
                .pattern("NNN")
                .input('X', Items.REDSTONE_BLOCK)
                .input('Z', RainyItems.COPPER_WIRE)
                .input('N', Items.GOLD_INGOT)
                .input('Y', Items.STONE_BRICKS)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter);







    }
}
