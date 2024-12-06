package com.tomqnto.tomqntomod.block;

import com.tomqnto.tomqntomod.TomqntoMod;
import com.tomqnto.tomqntomod.item.TomqntoItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

// --------------------------------------ModBLocks CLASS-------------------------------------------

public class ModBlocks {

    public static final Block DEEPSLATE_LUMINITE_ORE = registerModBlock(
            "deepslate_luminite_ore",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(4.4f, 4.5f).sounds(BlockSoundGroup.DEEPSLATE)),
            true);

    public static final Block LUMINITE_BLOCK = registerModBlock(
            "luminite_block",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(4.4f, 4.5f).sounds(BlockSoundGroup.STONE)),
            true);

    public static final Block MAHOGANY_LOG = registerModBlock(
            "mahogany_log",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0f, 7.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block STRIPPED_MAHOGANY_LOG = registerModBlock(
            "stripped_mahogany_log",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0f, 7.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_WOOD = registerModBlock(
            "mahogany_wood",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0f, 7.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_PLANKS = registerModBlock(
            "mahogany_planks",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);


    // ----------------------------------REGISTER MOD BLOCK & BLOCk ITEM METHOD-----------------------------------------------

    public static Block registerModBlock(String name, Block block, boolean shouldRegisterItem) {

        Identifier blockID = Identifier.of(TomqntoMod.MOD_ID, name);

        // Register block item if shouldRegisterItem is true
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, blockID, blockItem);
        }

        TomqntoMod.LOGGER.info("Registering Mod Block: " + name);

        // Register block
        return Registry.register(Registries.BLOCK, blockID, block);
    }

// -----------------------------------MOD BLOCK INITIALIZE--------------------------------------------------

    public static void initialize() {
        TomqntoItemGroup.addBlockItemsToItemGroup();
    }

}
