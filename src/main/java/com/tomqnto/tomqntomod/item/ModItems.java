package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;


public class ModItems {


    // Food Components
    public final static FoodComponent GLOW_FOOD_COMPONENT = ModFoodComponents.GLOW_FOOD_COMPONENT;

    // --------------------------------------REGISTERING/ADDING ITEMS-----------------------------------------

    // Creates the Item
    public static final Item RAW_LUMINITE = registerModItem(new ItemRaw_Luminite(new Item.Settings()),
            "raw_luminite");

    public static final Item LUMINITE_INGOT = registerModItem(new Item(new Item.Settings()),
            "luminite_ingot");

    public static final Item LUMINOUS_APPLE = registerModItem(new ItemLuminous_Apple(new Item.Settings().food(GLOW_FOOD_COMPONENT)),
            "luminous_apple");

    // Tools
    public static final Item LUMINITE_SWORD = registerModItem
            (new SwordItemLuminite_Sword(ModToolMaterials.LUMINITE,  new Item.Settings()), "luminite_sword");

    //Armor Items
    public static final Item LUMINITE_HELMET =
            registerModItem(new ArmorItem(new ModArmorMaterials().LUMINITE,
                            ArmorItem.Type.HELMET, new Item.Settings()
                            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))),
                    "luminite_helmet");


    public static final Item LUMINITE_CHESTPLATE =
            registerModItem(new ArmorItem(new ModArmorMaterials().LUMINITE,
                            ArmorItem.Type.CHESTPLATE, new Item.Settings()
                            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))),
                    "luminite_chestplate");

    public static final Item LUMINITE_LEGGINGS =
            registerModItem(new ArmorItem(new ModArmorMaterials().LUMINITE,
                            ArmorItem.Type.LEGGINGS, new Item.Settings()
                            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))),
                    "luminite_leggings");


    public static final Item LUMINITE_BOOTS =
            registerModItem(new ArmorItem(new ModArmorMaterials().LUMINITE,
                            ArmorItem.Type.BOOTS, new Item.Settings()
                            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(ModArmorMaterials.LUMINITE_DURABILITY_MULTIPLIER))),
                    "luminite_boots");

// --------------------------------ITEM REGISTER METHOD----------------------------------------

    // Item register method
    public static Item registerModItem(Item item, String id) {
        
        // Create the identifier for the item
        Identifier itemID = Identifier.of(TomqntoMod.MOD_ID, id);


        // Send message to log
        TomqntoMod.LOGGER.info("Registering Mod Items for " + TomqntoMod.MOD_ID);

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

// ----------------------------------ITEM CLASSES FOR TOOLTIPS-----------------------------------------------

// Item with tooltips

class ItemRaw_Luminite extends Item {

    public ItemRaw_Luminite(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("A rare ore!").formatted(Formatting.AQUA));
    }
}

class ItemLuminous_Apple extends Item {

    public ItemLuminous_Apple(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("A Luminous Apple, get energized!").formatted(Formatting.AQUA));
    }
}

class SwordItemLuminite_Sword extends SwordItem {

    public SwordItemLuminite_Sword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Attack Damage: " + ModToolMaterials.LUMINITE.getAttackDamage()).formatted(Formatting.AQUA));
        tooltip.add(Text.literal("Repair Ingredients: " + ModToolMaterials.LUMINITE.getRepairIngredient()).formatted(Formatting.AQUA));

    }
}


