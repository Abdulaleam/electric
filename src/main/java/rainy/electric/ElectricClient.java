package rainy.electric;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import rainy.electric.entity.ModBlockEntities;
import rainy.electric.entity.render.InsulatorBlockEntityRender;

public class ElectricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockEntityRendererFactories.register(ModBlockEntities.INSULATOR_BE, InsulatorBlockEntityRender::new);

    }
}
