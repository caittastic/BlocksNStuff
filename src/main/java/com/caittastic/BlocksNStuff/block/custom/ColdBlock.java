package com.caittastic.BlocksNStuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.awt.*;

import static com.caittastic.BlocksNStuff.item.custom.FireTrinket.lightEntityOnFire;

public class ColdBlock extends Block {
    public ColdBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(!worldIn.isRemote()){
            if(handIn == Hand.MAIN_HAND){
                System.out.println("i right clicked cold block, main hand");
            }
            if(handIn == Hand.OFF_HAND){
                System.out.println("i right clicked cold block, OFFHAND");
            }
        }


        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }


    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote()){

                System.out.println("i left clicked cold block");

        }



    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));
            ((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 200));
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }



}
