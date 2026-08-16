package rainy.electric.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import rainy.electric.Electric;

public class ModScreenHandlers {

    public static final ScreenHandlerType<DisplayerScreenHandler> DISPLAYER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Electric.MOD_ID, "displayer_screen_handler"),
                    new ExtendedScreenHandlerType<>(DisplayerScreenHandler:: new, BlockPos.PACKET_CODEC));


    public static void registerscreenHandlers() {
        Electric.LOGGER.info("registering screen handlers FOR " + Electric.MOD_ID );
    }
}
