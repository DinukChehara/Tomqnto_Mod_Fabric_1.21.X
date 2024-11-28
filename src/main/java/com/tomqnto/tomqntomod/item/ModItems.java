package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import com.tomqnto.tomqntomod.item.ToolMaterials.LuminiteToolMaterial;
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


    // Creates the Item
    public static final Item RAW_LUMINITE = registerItem(new ItemRaw_Luminite(new Item.Settings()),
            "raw_luminite");

    public static final Item LUMINITE_INGOT = registerItem(new Item(new Item.Settings()),
            "luminite_ingot");

    public static final Item LUMINOUS_APPLE = registerItem(new ItemLuminous_Apple(new Item.Settings().food(GLOW_FOOD_COMPONENT)),
            "luminous_apple");

    // Tools
    public static final Item LUMINITE_SWORD = registerItem
            (new SwordItemLuminite_Sword(LuminiteToolMaterial.INSTANCE,  new Item.Settings()), "luminite_sword");

    // Item register method
    public static Item registerItem(Item item, String id) {
        
        // Create the identifier for the item
        Identifier itemID = Identifier.of(TomqntoMod.MOD_ID, id);

        // Register and return the item.
        return Registry.register(Registries.ITEM, itemID, item);
    }


    public static void initialize() {
        // Adds the items to an ItemGroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).
                register((itemGroup) -> itemGroup.add(ModItems.RAW_LUMINITE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).
                register((itemGroup) -> itemGroup.add(ModItems.LUMINITE_INGOT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).
                register((itemGroup) -> itemGroup.add(ModItems.LUMINOUS_APPLE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).
                register((itemGroup) -> itemGroup.add(ModItems.LUMINITE_SWORD));



        // When used as fuel, it will take 5 seconds(20 ticks = 1 second) to complete smelting
        FuelRegistry.INSTANCE.add(ModItems.RAW_LUMINITE, 5 * 20);
    }

}

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
        tooltip.add(Text.literal("Attack Damage: " + LuminiteToolMaterial.INSTANCE.getAttackDamage()).formatted(Formatting.AQUA));
        tooltip.add(Text.literal("Repair Ingredients: " + LuminiteToolMaterial.INSTANCE.getRepairIngredient()).formatted(Formatting.AQUA));

    }
}


