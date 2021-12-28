package com.caittastic.BlocksNStuff.block;

import com.caittastic.BlocksNStuff.BlocksNStuff;
import com.caittastic.BlocksNStuff.block.custom.ColdBlock;
import com.caittastic.BlocksNStuff.item.ModItemGroup;
import com.caittastic.BlocksNStuff.item.Moditems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    //the register for all our blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BlocksNStuff.MOD_ID);

    //adds examplite_block
    //material is kinda how the game will see what type of block it is, and does stuff with that
    //harvest level, what level of tool do you require to break your item
    //tool type is what tool can break your block
    //hardness is the speed to mine, resistance is its explosion proof-ness
    public static final RegistryObject<Block> EXAMPLITE_BLOCK = registerBlock("examplite_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));

    //examplite_ore
    public static final RegistryObject<Block> EXAMPLITE_ORE = registerBlock("examplite_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3,3)));

    //================MAGIC BLOCKS================
    //cold_block
    public static final RegistryObject<Block> COLD_BLOCK = registerBlock("cold_block",
            () -> new ColdBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3,3)));










    //something to make things convenient, god if i know what it does though or why
    //it registers a block and makes a new item for it
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //creates an item for a block?
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));
    }


    //something to make things convenient? idk actually
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
