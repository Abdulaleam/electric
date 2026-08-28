package rainy.electric.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
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
            FabricItemGroup.builder().icon(()-> new ItemStack(RainyItems.CHARGED_BATTERY))
                    .displayName(Text.translatable("itemgroup.electric.electric_era_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(RainyItems.CHARGED_BATTERY);
                        entries.add(RainyItems.EMPTY_BATTERY);
                        entries.add(RainyBlocks.ZINC_ORE);
                        entries.add(RainyItems.ZINC_DUST);
                        entries.add(RainyItems.ZINC_PILE);
                        entries.add(RainyItems.ZINC_INGOT);
                        entries.add(RainyBlocks.DISPLAYER);
                        entries.add(RainyBlocks.INSULATOR);
                        entries.add(RainyItems.COPPER_WIRE);
                        entries.add(RainyItems.ZINC_WIRE);
                        entries.add(RainyItems.GOLD_WIRE);
                        entries.add(RainyItems.COPPER_INSULATED_WIRE);
                        entries.add(RainyItems.INSULATED_ZINC_WIRE);
                        entries.add(RainyItems.INSULATED_GOLD_WIRE);
                        entries.add(RainyItems.COPPER_COIL);
                        entries.add(RainyItems.ZINC_COIL);
                        entries.add(RainyItems.GOLD_COIL);


                    })

                    .build()
    );



    public static void registerRainyItemGroups() {}

}
