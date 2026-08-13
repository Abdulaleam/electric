package rainy.electric;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rainy.electric.item.RainyItems;

public class Electric implements ModInitializer {
	public static final String MOD_ID = "electric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);




	@Override
	public void onInitialize() {
		RainyItems.registerRainyItems();





	}

}
