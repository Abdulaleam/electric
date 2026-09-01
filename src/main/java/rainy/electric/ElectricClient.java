package rainy.electric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import rainy.electric.entity.ModBlockEntities;
import rainy.electric.entity.render.DisplayerBlockEntityRender;
import rainy.electric.screen.*;

public class ElectricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockEntityRendererFactories.register(ModBlockEntities.DISPLAYER_BE, DisplayerBlockEntityRender::new);



        HandledScreens.register(ModScreenHandlers.DISPLAYER_SCREEN_HANDLER, DisplayerScreen::new);

        HandledScreens.register(ModScreenHandlers.INSULATOR_SCREEN_HANDLER, InsulatorScreen::new);

        HandledScreens.register(ModScreenHandlers.PRESSURE_SCREEN_HANDLER, PressureScreen::new);

        HandledScreens.register(ModScreenHandlers.COILER_SCREEN_HANDLER, CoilerScreen::new);



    }
}
