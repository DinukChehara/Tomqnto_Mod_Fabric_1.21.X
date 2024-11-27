package com.tomqnto.tomqntomod;

import com.tomqnto.tomqntomod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TomqntoMod implements ModInitializer{

	public static final String MOD_ID = "tomqntomod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// WHen onInitialize is called, initialize method in ModItems is called.
	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}