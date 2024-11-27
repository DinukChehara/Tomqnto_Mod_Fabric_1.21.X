package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item registerItem(Item item, String id) {
        
        // Create the identifier for the item
        Identifier itemID = Identifier.of(TomqntoMod.MOD_ID, id);

        // Register the item
        Item registerItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item
        return registerItem;
    }


    public static void initialize() {
        // Adds the items to an ItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).
                register((itemGroup) -> itemGroup.add(ModItems.RAW_LUMINITE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).
                register((itemGroup) -> itemGroup.add(ModItems.LUMINITE_INGOT));


        // When used as fuel, it will take 5 seconds(20 ticks = 1 second) to complete smelting
        FuelRegistry.INSTANCE.add(ModItems.RAW_LUMINITE, 5 * 20);
    }

    // Creates the Item
    public static final Item RAW_LUMINITE = registerItem(new Item(new Item.Settings()),
            "raw_luminite");

    public static final Item LUMINITE_INGOT = registerItem(new Item(new Item.Settings()),
            "luminite_ingot");

}
