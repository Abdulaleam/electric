package rainy.electric.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;
import rainy.electric.block.RainyBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<DisplayerBlockEntity> INSULATOR_BE=
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Electric.MOD_ID, "insulat0r_be"),
                    BlockEntityType.Builder.create(DisplayerBlockEntity::new, RainyBlocks.DISPLAYER).build(null));


    public static void registerBlockEntities() {
        Electric.LOGGER.info("Registering block entities for" + Electric.MOD_ID);
    }
}
