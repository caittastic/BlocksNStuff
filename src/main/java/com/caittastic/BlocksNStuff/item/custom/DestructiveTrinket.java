package com.caittastic.BlocksNStuff.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockState;


public class DestructiveTrinket extends Item {
    public DestructiveTrinket(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();
        context.getPlayer().getHorizontalFacing();

        superBreaker(context);
        return super.onItemUseFirst(stack, context);
    }

    //helpful :)
    private boolean blockValidToBreak(BlockState clickedBlock, ItemUseContext context, World world) {
        BlockPos blockpos = context.getPos();
        return clickedBlock.getBlockHardness(world,context.getPos()) > 0f;
    }

    //
    private void superBreaker(ItemUseContext context){
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();
        int[] iterateLoop  = {-1,0,1};



        //facing north/south
        if( context.getFace() == Direction.NORTH || context.getFace() == Direction.SOUTH) {
            for (int _i : iterateLoop) {
                for (int _j : iterateLoop) {

                    //changing variables to match the new itterated block
                    BlockPos newBlockPos = blockPos.add(_j, _i, 0);
                    BlockState newClickedBlock = world.getBlockState(newBlockPos);


                    if (blockValidToBreak(newClickedBlock, context, world)) {
                        world.destroyBlock(newBlockPos, true);
                    }
                }

            }
        }

        //facing east/west
        if( context.getFace() == Direction.EAST || context.getFace() == Direction.WEST) {
            for (int _i : iterateLoop) {
                for (int _j : iterateLoop) {

                    //changing variables to match the new itterated block
                    BlockPos newBlockPos = blockPos.add(0, _i, _j);
                    BlockState newClickedBlock = world.getBlockState(newBlockPos);


                    if (blockValidToBreak(newClickedBlock, context, world)) {
                        world.destroyBlock(newBlockPos, true);
                    }
                }

            }
        }

        //facing up/down
        if( context.getFace() == Direction.UP || context.getFace() == Direction.DOWN) {
            for (int _i : iterateLoop) {
                for (int _j : iterateLoop) {

                    //changing variables to match the new itterated block
                    BlockPos newBlockPos = blockPos.add(_i, 0, _j);
                    BlockState newClickedBlock = world.getBlockState(newBlockPos);


                    if (blockValidToBreak(newClickedBlock, context, world)) {
                        world.destroyBlock(newBlockPos, true);
                    }
                }
            }
        }
    }

}



