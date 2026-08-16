package rainy.electric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import rainy.electric.entity.ModBlockEntities;
import rainy.electric.entity.render.InsulatorBlockEntityRender;
import rainy.electric.screen.DisplayerScreen;
import rainy.electric.screen.ModScreenHandlers;

public class ElectricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockEntityRendererFactories.register(ModBlockEntities.INSULATOR_BE, InsulatorBlockEntityRender::new);

        HandledScreens.register(ModScreenHandlers.DISPLAYER_SCREEN_HANDLER, DisplayerScreen::new);

    }
}
