package com.caittastic.BlocksNStuff.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    //the name of our item group in the code
    // the label of our item group
    public static final ItemGroup BLOCKS_N_STUFF =  new ItemGroup("blocksnstuff_tab") {
        @Override
        //the logo of the tab will be this item
        public ItemStack createIcon() {
            return new ItemStack(Moditems.EXAMPLE_ITEM.get());
        }
    };

}
