package com.tomqnto.tomqntomod.item;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static void initialize() {};

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial
            (String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability,
             RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier,
             float toughness, float knockbackResistance, boolean dyeable) {

        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(

                // ID of the texture layer, Suffix("" for empty suffix), dyeable - true/false
                new ArmorMaterial.Layer(Identifier.of(TomqntoMod.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial
                (defensePoints, enchantability, equipSound, repairIngredientSupplier, layers,
                        toughness, knockbackResistance);

        // Register the material within the ArmorMaterials registry
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(TomqntoMod.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);

    }

    //------------------------------------REGISTERING THE ARMOR MOD ARMOR MATERIALS--------------------------------------------------

    // ARMOR ITEMS
    public static final RegistryEntry<ArmorMaterial> LUMINITE = registerArmorMaterial(
            "luminite",
            // defense points of each armor piece
            Map.of(ArmorItem.Type.HELMET, 5,
                    ArmorItem.Type.CHESTPLATE, 9,
                    ArmorItem.Type.LEGGINGS, 7,
                    ArmorItem.Type.BOOTS, 5),
            4,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(ModItems.LUMINITE_INGOT),
            3.5f,
            1.5f,
            false
    );

    // ARMOR ITEM DURABILITY MULTIPLIERS
    public static final int LUMINITE_DURABILITY_MULTIPLIER = 15;

}
