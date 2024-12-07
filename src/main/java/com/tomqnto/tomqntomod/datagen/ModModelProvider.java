package com.tomqnto.tomqntomod.datagen;

import com.tomqnto.tomqntomod.block.ModBlocks;
import com.tomqnto.tomqntomod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LUMINITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUMINITE_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.MAHOGANY_LOG).log(ModBlocks.MAHOGANY_LOG).wood(ModBlocks.MAHOGANY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MAHOGANY_LOG).log(ModBlocks.STRIPPED_MAHOGANY_LOG).wood(ModBlocks.STRIPPED_MAHOGANY_WOOD);

        BlockStateModelGenerator.BlockTexturePool mahoganyPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MAHOGANY_PLANKS);

        mahoganyPlankPool.slab(ModBlocks.MAHOGANY_SLABS);
        mahoganyPlankPool.stairs(ModBlocks.MAHOGANY_STAIRS);
        mahoganyPlankPool.button(ModBlocks.MAHOGANY_BUTTON);
        mahoganyPlankPool.pressurePlate(ModBlocks.MAHOGANY_PRESSURE_PLATE);
        mahoganyPlankPool.fence(ModBlocks.MAHOGANY_FENCE);
        mahoganyPlankPool.fenceGate(ModBlocks.MAHOGANY_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.MAHOGANY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MAHOGANY_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.RAW_LUMINITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.LUMINOUS_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LUMINITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.LUMINITE_SWORD, Models.HANDHELD);
    }
}
