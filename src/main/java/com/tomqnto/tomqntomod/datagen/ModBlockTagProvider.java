package com.tomqnto.tomqntomod.datagen;

import com.tomqnto.tomqntomod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_LUMINITE_ORE)
                .add(ModBlocks.LUMINITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.DEEPSLATE_LUMINITE_ORE)
                .add(ModBlocks.LUMINITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MAHOGANY_LOG)
                .add(ModBlocks.MAHOGANY_WOOD)
                .add(ModBlocks.MAHOGANY_PLANKS)
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD)

                .add(ModBlocks.MAHOGANY_STAIRS)
                .add(ModBlocks.MAHOGANY_SLABS)
                .add(ModBlocks.MAHOGANY_FENCE)
                .add(ModBlocks.MAHOGANY_FENCE_GATE)
                .add(ModBlocks.MAHOGANY_PRESSURE_PLATE)
                .add(ModBlocks.MAHOGANY_BUTTON)
                .add(ModBlocks.MAHOGANY_DOOR)
                .add(ModBlocks.MAHOGANY_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.MAHOGANY_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MAHOGANY_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS);
    }
}
