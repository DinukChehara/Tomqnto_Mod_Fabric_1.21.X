package com.tomqnto.tomqntomod.datagen;

import com.tomqnto.tomqntomod.TomqntoMod;
import com.tomqnto.tomqntomod.block.ModBlocks;
import com.tomqnto.tomqntomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.core.pattern.EqualsIgnoreCaseReplacementConverter;

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
                .pattern("L L")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_CHESTPLATE)
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_LEGGINGS)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_BOOTS)
                .pattern("L L")
                .pattern("L L")
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(recipeExporter);

        offerReversibleCompactingRecipes(recipeExporter,
                RecipeCategory.BUILDING_BLOCKS,  ModItems.LUMINITE_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.LUMINITE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.MAHOGANY_LOG.asItem())
                .criterion(hasItem(ModBlocks.MAHOGANY_LOG), conditionsFromItem(ModBlocks.MAHOGANY_LOG))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_PLANKS, 4)
                .input(ModBlocks.STRIPPED_MAHOGANY_LOG.asItem())
                .criterion(hasItem(ModBlocks.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .offerTo(recipeExporter, Identifier.of(TomqntoMod.MOD_ID, "mahogany_planks_from_stripped_log"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_WOOD, 3)
                .pattern("MM")
                .pattern("MM")
                .input('M', ModBlocks.MAHOGANY_LOG.asItem())
                .criterion(hasItem(ModBlocks.MAHOGANY_LOG), conditionsFromItem(ModBlocks.MAHOGANY_LOG))
                .offerTo(recipeExporter);

        createDoorRecipe(ModBlocks.MAHOGANY_DOOR, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAHOGANY_SLABS, ModBlocks.MAHOGANY_PLANKS);

        createFenceRecipe(ModBlocks.MAHOGANY_FENCE, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        createStairsRecipe(ModBlocks.MAHOGANY_STAIRS, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        createFenceGateRecipe(ModBlocks.MAHOGANY_FENCE_GATE, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        createTrapdoorRecipe(ModBlocks.MAHOGANY_TRAPDOOR, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        createPressurePlateRecipe(RecipeCategory.REDSTONE ,ModBlocks.MAHOGANY_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.MAHOGANY_PLANKS))
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MAHOGANY_BUTTON)
                .input(ModBlocks.MAHOGANY_PLANKS)
                .criterion(hasItem(ModBlocks.MAHOGANY_PLANKS), conditionsFromItem(ModBlocks.MAHOGANY_PLANKS))
                .offerTo(recipeExporter);

    }
}
