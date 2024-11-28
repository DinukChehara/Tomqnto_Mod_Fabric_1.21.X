package com.tomqnto.tomqntomod.item.ToolMaterials;

import com.tomqnto.tomqntomod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class LuminiteToolMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 1560;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0f;
    }

    @Override
    public float getAttackDamage() {
        return 1444.3f;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.LUMINITE_INGOT);
    }

    public static final LuminiteToolMaterial INSTANCE = new LuminiteToolMaterial();

}
