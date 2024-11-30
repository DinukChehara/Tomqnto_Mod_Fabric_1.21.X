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
        itemModelGenerator.register(ModItems.LUMINITE_SWORD, Models.GENERATED);
    }
}
