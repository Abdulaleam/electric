package rainy.electric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import rainy.electric.datagen.RainyLootTableProvider;
import rainy.electric.datagen.RainyModelProvider;
import rainy.electric.datagen.RainyRecipeProvider;

public class ElectricDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


		pack.addProvider(RainyLootTableProvider::new);
		pack.addProvider(RainyModelProvider::new);
		pack.addProvider(RainyRecipeProvider::new);

	}
}
