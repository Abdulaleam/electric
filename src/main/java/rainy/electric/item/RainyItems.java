package rainy.electric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rainy.electric.Electric;

public class RainyItems {

    public static final Item  EMPTY_BATTERY = registerItem("empty_battery", new Item(new Item.Settings()));

    public static final Item CHARGED_BATTERY = registerItem("charged_battery", new ChargedHitEffect(new Item.Settings()));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(Electric.MOD_ID, name), item);




    }





    public static void  registerRainyItems(){
        Electric.LOGGER.info("Registering RainyItems");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries ->{
            entries.add(EMPTY_BATTERY);
            entries.add(CHARGED_BATTERY);



        });
    }


}
