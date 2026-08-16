package rainy.electric.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;

public class RainyBlocks {

    public static final Block ZINC_ORE = registerBlock("zinc_ore", new Block(AbstractBlock.Settings.create().strength(4f)
            .sounds(BlockSoundGroup.NETHER_BRICKS)));
    public static final Block DISPLAYER = registerBlock("displayer",
            new DisplayerBlock(AbstractBlock.Settings.create().nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerRainyBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Electric.MOD_ID, name), block);
    }


    private static void registerRainyBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Electric.MOD_ID, name), new BlockItem(block, new Item.Settings()));

    }

    public static void registerRainyBlocks() {
        Electric.LOGGER.info("Registering RainyBlocks");
    }

}
