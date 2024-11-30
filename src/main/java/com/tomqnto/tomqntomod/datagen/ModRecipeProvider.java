package com.tomqnto.tomqntomod.datagen;

import com.tomqnto.tomqntomod.block.ModBlocks;
import com.tomqnto.tomqntomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> LUMINITE_SMETABLES = List.of(ModItems.RAW_LUMINITE, ModBlocks.DEEPSLATE_LUMINITE_ORE);

        offerSmelting(recipeExporter, LUMINITE_SMETABLES, RecipeCategory.MISC, ModItems.LUMINITE_INGOT, 0.5f, 200, "luminite");
        offerBlasting(recipeExporter, LUMINITE_SMETABLES, RecipeCategory.MISC, ModItems.LUMINITE_INGOT, 0.5f, 100, "luminite");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_HELMET)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_CHESTPLATE)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_LEGGINGS)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_BOOTS)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

    }
}
