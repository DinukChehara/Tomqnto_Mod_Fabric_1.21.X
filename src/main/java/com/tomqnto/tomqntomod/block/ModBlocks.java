package com.tomqnto.tomqntomod.block;

import com.tomqnto.tomqntomod.TomqntoMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

// --------------------------------------ModBLocks CLASS-------------------------------------------

public class ModBlocks {

    public static final Block LUMINITE_ORE = registerModBlock(
            new Block(AbstractBlock.Settings.create().requiresTool().strength(4.4f, 4.5f).sounds(BlockSoundGroup.DEEPSLATE)),
            "luminite_ore",
            true);


    // ----------------------------------REGISTER MOD BLOCK & BLOCk ITEM METHOD-----------------------------------------------

    public static Block registerModBlock(Block block, String name, boolean shouldRegisterItem) {
        //Register the block and its item
        Identifier blockID = Identifier.of(TomqntoMod.MOD_ID, name);

        // Register item if shouldRegisterItem is true
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, blockID, blockItem);
        }

        // Register block
        return Registry.register(Registries.BLOCK, blockID, block);
    }

// -----------------------------------MOD BLOCK INITIALIZE--------------------------------------------------

    public static void initialize() {

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
//                .register((itemGroup) -> itemGroup
//                        .add(ModBlocks.LUMINITE_ORE.asItem()));
    }

}
