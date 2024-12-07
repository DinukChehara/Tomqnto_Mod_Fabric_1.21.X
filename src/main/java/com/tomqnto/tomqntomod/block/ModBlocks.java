package com.tomqnto.tomqntomod.block;

import com.tomqnto.tomqntomod.TomqntoMod;
import com.tomqnto.tomqntomod.item.TomqntoItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    public static final Block STRIPPED_MAHOGANY_WOOD = registerModBlock(
            "stripped_mahogany_wood",
            new PillarBlock(AbstractBlock.Settings.create().requiresTool().strength(2.0f, 7.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_PLANKS = registerModBlock(
            "mahogany_planks",
            new Block(AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_SLABS = registerModBlock(
            "mahogany_slabs",
            new SlabBlock(AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_STAIRS = registerModBlock(
            "mahogany_stairs",
            new StairsBlock(ModBlocks.MAHOGANY_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_FENCE = registerModBlock(
            "mahogany_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_FENCE_GATE = registerModBlock(
            "mahogany_fence_gate",
            new FenceGateBlock(WoodType.OAK,AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_BUTTON = registerModBlock(
            "mahogany_button",
            new ButtonBlock(BlockSetType.OAK, 10 ,AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).noCollision().sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_PRESSURE_PLATE = registerModBlock(
            "mahogany_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD)),
            true);

    public static final Block MAHOGANY_TRAPDOOR = registerModBlock(
            "mahogany_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()),
            true);

    public static final Block MAHOGANY_DOOR = registerModBlock(
            "mahogany_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().requiresTool().strength(2.7f, 5.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()),
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

