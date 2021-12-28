package com.caittastic.BlocksNStuff.item;

import com.caittastic.BlocksNStuff.BlocksNStuff;
import com.caittastic.BlocksNStuff.item.custom.DestructiveTrinket;
import com.caittastic.BlocksNStuff.item.custom.FireTrinket;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Moditems {

    //this creates a list that keeps track of all sorts of items and whatnot in our mod so forge knows whats going on and can register it correctly
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BlocksNStuff.MOD_ID);


    //this registers and creates our item
    //we register it as an item
    //we give it a name in the code, "EXAMPLE_ITEM"
    //we name it "example_item"
    //
    //what creative tab the item will be in

    //example_item, orb of example
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF).maxStackSize(16)));

    //testing_rod, Rod Of Experiments
    public static final RegistryObject<Item> TESTING_ROD = ITEMS.register("testing_rod",
            () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF).maxStackSize(1)));

    //raw_examplite
    public static final RegistryObject<Item> RAW_EXAMPLITE = ITEMS.register("raw_examplite",
            () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

    //examplite_ingot
    public static final RegistryObject<Item> EXAMPLITE_INGOT = ITEMS.register("examplite_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

    //================DUSTS==============
        //charcoal_dust
        public static final RegistryObject<Item> CHARCOAL_DUST = ITEMS.register("charcoal_dust",
                () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

        //dust_low
        public static final RegistryObject<Item> DUST_LOW = ITEMS.register("dust_low",
                () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

        //dust_mid
        public static final RegistryObject<Item> DUST_MID = ITEMS.register("dust_mid",
                () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

        //dust_high
        public static final RegistryObject<Item> DUST_HIGH = ITEMS.register("dust_high",
                () -> new Item(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));

    //================TRINKETS================
        //firey_trinket
        public static final RegistryObject<Item> FIREY_TRINKET = ITEMS.register("firey_trinket",
                () -> new FireTrinket(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF).maxDamage(8)));

        //destroy_trinket
        public static final RegistryObject<Item> DESTROY_TRINKET = ITEMS.register("destroy_trinket",
                () -> new DestructiveTrinket(new Item.Properties().group(ModItemGroup.BLOCKS_N_STUFF)));







    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

