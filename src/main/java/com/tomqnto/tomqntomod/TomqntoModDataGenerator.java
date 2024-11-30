package com.tomqnto.tomqntomod;

import com.tomqnto.tomqntomod.datagen.ModBlockTagProvider;
import com.tomqnto.tomqntomod.datagen.ModLootTableProvider;
import com.tomqnto.tomqntomod.datagen.ModModelProvider;
import com.tomqnto.tomqntomod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TomqntoModDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
