package rainy.electric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import rainy.electric.block.RainyBlocks;
import rainy.electric.item.RainyItems;

import java.util.List;
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
                .input('X', RainyItems.CHARGED_BATTERY)
                .input('Z', RainyItems.GOLD_WIRE)
                .input('N', Items.REDSTONE)
                .input('Y', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);







    }
}
