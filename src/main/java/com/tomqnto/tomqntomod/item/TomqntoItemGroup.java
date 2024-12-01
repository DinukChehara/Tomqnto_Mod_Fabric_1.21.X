package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class TomqntoItemGroup {
    // item group key
    public static final RegistryKey<ItemGroup> TOMQNTOMOD_KEY = RegistryKey.of
            (Registries.ITEM_GROUP.getKey(), Identifier.of(TomqntoMod.MOD_ID, "tomqntomod"));
    // item group
    public static final ItemGroup TOMQNTOMOD = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.LUMINITE_INGOT))
            .displayName(Text.literal("Tomqnto Mod Items").formatted(Formatting.AQUA))
            .build();

    // register the group
    public static void registerItemGroup() {
        Registry.register(Registries.ITEM_GROUP, TOMQNTOMOD_KEY, TOMQNTOMOD);
        TomqntoMod.LOGGER.info("Registered Item Group: TOMQNTOMOD - " + TOMQNTOMOD_KEY);
    }

    // add items to the group
    public static void addItemsToItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(TOMQNTOMOD_KEY)
                .register(itemGroup -> {
                    itemGroup.add(ModItems.RAW_LUMINITE);
                    itemGroup.add(ModItems.LUMINITE_INGOT);
                    itemGroup.add(ModItems.LUMINOUS_APPLE);
                    itemGroup.add(ModItems.LUMINITE_SWORD);
                    itemGroup.add(ModItems.LUMINITE_HELMET);
                    itemGroup.add(ModItems.LUMINITE_CHESTPLATE);
                    itemGroup.add(ModItems.LUMINITE_LEGGINGS);
                    itemGroup.add(ModItems.LUMINITE_BOOTS);
                });
        TomqntoMod.LOGGER.info("Added items to item group TomqntoMod");
    }

}
