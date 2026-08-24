package rainy.electric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import rainy.electric.block.RainyBlocks;
import rainy.electric.item.RainyItems;

public class RainyModelProvider extends FabricModelProvider {
    public RainyModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RainyBlocks.ZINC_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RainyItems.BEATING_HEART, Models.GENERATED);
        itemModelGenerator.register(RainyItems.DORMANT_HEART, Models.GENERATED);
        itemModelGenerator.register(RainyItems.MARROW_HEAP, Models.GENERATED);
        itemModelGenerator.register(RainyItems.MARROW_DUST, Models.GENERATED);
        itemModelGenerator.register(RainyItems.COPPER_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.COPPER_COIL, Models.GENERATED);
        itemModelGenerator.register(RainyItems.MARROW_INGOT, Models.GENERATED);
        itemModelGenerator.register(RainyItems.COPPER_INSULATED_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.INSULATED_ZINC_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.GOLD_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.INSULATED_GOLD_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.GOLD_COIL, Models.GENERATED);
        itemModelGenerator.register(RainyItems.ZINC_WIRE, Models.GENERATED);
        itemModelGenerator.register(RainyItems.ZINC_COIL, Models.GENERATED);

    }
}
