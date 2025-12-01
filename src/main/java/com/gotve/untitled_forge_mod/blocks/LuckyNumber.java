package com.gotve.untitled_forge_mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class LuckyNumber extends Block {

    public LuckyNumber(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (!level.isClientSide) {
            Random random = new Random();
            int randomNumber = random.nextInt();
            player.sendSystemMessage(Component.literal(String.valueOf(randomNumber)));
        }
        return InteractionResult.SUCCESS;
    }
}
