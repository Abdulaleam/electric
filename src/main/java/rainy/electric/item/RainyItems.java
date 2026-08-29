package rainy.electric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;

import static rainy.electric.block.RainyBlocks.*;

public class RainyItems {
    public static final Item ZINC_DUST = registerItem("zinc_dust", new Item(new Item.Settings()));

        public static final Item ZINC_PILE = registerItem("zinc_pile", new Item(new Item.Settings()));

    public static final Item ZINC_INGOT = registerItem("zinc_ingot", new Item(new Item.Settings()));

    public static final Item CHARGED_BATTERY = registerItem("charged_battery", new ChargedHitEffect(new Item.Settings()));

    public static final Item EMPTY_BATTERY = registerItem("empty_battery", new ChargedHitEffect(new Item.Settings()));

    public static final Item COPPER_COIL = registerItem("copper_coil", new Item(new Item.Settings()));

    public static final Item COPPER_WIRE = registerItem("copper_wire", new Item(new Item.Settings()));

    public static final Item COPPER_INSULATED_WIRE = registerItem("copper_insulated_wire", new Item(new Item.Settings()));

    public static final Item ZINC_WIRE = registerItem("zinc_wire", new Item(new Item.Settings()));
    public static final Item INSULATED_ZINC_WIRE = registerItem("insulated_zinc_wire", new Item(new Item.Settings()));
    public static final Item GOLD_WIRE = registerItem("gold_wire", new Item(new Item.Settings()));
    public static final Item INSULATED_GOLD_WIRE = registerItem("insulated_gold_wire", new Item(new Item.Settings()));
    public static final Item ZINC_COIL = registerItem("zinc_coil", new Item(new Item.Settings()));
    public static final Item GOLD_COIL = registerItem("gold_coil", new Item(new Item.Settings()));

    public static final Item CIRCUIT = registerItem("circuit", new Item(new Item.Settings()));

    public static final Item UPGRADED_CIRCUIT = registerItem("upgraded_circuit", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(Electric.MOD_ID, name), item);




    }





    public static void  registerRainyItems(){
        Electric.LOGGER.info("Registering RainyItems");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->{
            entries.add(CHARGED_BATTERY);
            entries.add(EMPTY_BATTERY);
            entries.add(ZINC_DUST);
            entries.add(ZINC_PILE);
            entries.add(ZINC_ORE);
            entries.add(COPPER_COIL);
            entries.add(COPPER_WIRE);
            entries.add(DISPLAYER);
            entries.add(INSULATOR);



        });
    }


}
