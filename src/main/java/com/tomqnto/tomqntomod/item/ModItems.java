package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;


public class ModItems {

    // --------------------------------------REGISTERING/ADDING ITEMS-----------------------------------------

    // Creates the Item
    public static final Item RAW_LUMINITE =
            registerModItem("raw_luminite", new Item(new Item.Settings()));

    public static final Item LUMINITE_INGOT =
            registerModItem("luminite_ingot", new Item(new Item.Settings()));

    public static final Item LUMINOUS_APPLE =
            registerModItem("luminous_apple", new Item(new Item.Settings().food(ModFoodComponents.LUMINOUS_APPLE)){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.luminous_apple.shift_down"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.luminous_apple"));
                    }
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    // Tools
    public static final Item LUMINITE_SWORD =
            registerModItem("luminite_sword", new SwordItem(ModToolMaterials.LUMINITE, new Item.Settings()));

    // Armor Items
    public static final Item LUMINITE_HELMET =
            registerModItem("luminite_helmet", new ArmorItem(new ModArmorMaterials().LUMINITE,
                    ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))));

    public static final Item LUMINITE_CHESTPLATE =
            registerModItem("luminite_chestplate", new ArmorItem(new ModArmorMaterials().LUMINITE,
                    ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))));

    public static final Item LUMINITE_LEGGINGS =
            registerModItem("luminite_leggings", new ArmorItem(new ModArmorMaterials().LUMINITE,
                    ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))));

    public static final Item LUMINITE_BOOTS =
            registerModItem("luminite_boots", new ArmorItem(new ModArmorMaterials().LUMINITE,
                    ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))));

// --------------------------------ITEM REGISTER METHOD----------------------------------------

    // Item register method
    public static Item registerModItem(String id, Item item) {
        
        // Create the identifier for the item
        Identifier itemID = Identifier.of(TomqntoMod.MOD_ID, id);


        // Send message to log
        TomqntoMod.LOGGER.info("Registering Mod Item: " + id);

        // Register and return the item.
        return Registry.register(Registries.ITEM, itemID, item);

    }

// --------------------------------ITEM INITIALIZE METHOD---------------------------------------------

    // Item initialize
    public static void initialize() {
        TomqntoItemGroup.registerItemGroup();
        TomqntoItemGroup.addItemsToItemGroup();
    }

}



