package rainy.electric.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;
import rainy.electric.block.RainyBlocks;

public class RainyItemGroups {

    public static final ItemGroup ELECTRIC_ERA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Electric.MOD_ID, "electric_era_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(RainyItems.EMPTY_BATTERY))
                    .displayName(Text.translatable("itemgroup.electric.electric_era_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(RainyItems.EMPTY_BATTERY);
                        entries.add(RainyItems.CHARGED_BATTERY);
                        entries.add(RainyItems.ZINC_DUST);
                        entries.add(RainyItems.ZINC_PILE);
                        entries.add(RainyItems.COPPER_COIL);
                        entries.add(RainyItems.COPPER_WIRE);
                        entries.add(RainyItems.ZINC_INGOT);
                        entries.add(RainyBlocks.ZINC_ORE);
                        entries.add(RainyBlocks.INSULATOR);
                    })

                    .build()
    );



    public static void registerRainyItemGroups() {}

}
