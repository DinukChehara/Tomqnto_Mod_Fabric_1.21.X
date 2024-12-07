package com.tomqnto.tomqntomod.datagen;

import com.tomqnto.tomqntomod.block.ModBlocks;
import com.tomqnto.tomqntomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DEEPSLATE_LUMINITE_ORE,
                oreDrops(ModBlocks.DEEPSLATE_LUMINITE_ORE, ModItems.RAW_LUMINITE));
        addDrop(ModBlocks.LUMINITE_BLOCK);

        addDrop(ModBlocks.MAHOGANY_LOG);
        addDrop(ModBlocks.MAHOGANY_WOOD);
        addDrop(ModBlocks.MAHOGANY_PLANKS);
        addDrop(ModBlocks.STRIPPED_MAHOGANY_LOG);

        addDrop(ModBlocks.MAHOGANY_SLABS, slabDrops(ModBlocks.MAHOGANY_SLABS));
        addDrop(ModBlocks.MAHOGANY_STAIRS);
        addDrop(ModBlocks.MAHOGANY_BUTTON);
        addDrop(ModBlocks.MAHOGANY_PRESSURE_PLATE);
        addDrop(ModBlocks.MAHOGANY_FENCE);
        addDrop(ModBlocks.MAHOGANY_FENCE_GATE);
        addDrop(ModBlocks.MAHOGANY_TRAPDOOR);
        addDrop(ModBlocks.MAHOGANY_DOOR, doorDrops(ModBlocks.MAHOGANY_DOOR));
    }
}
