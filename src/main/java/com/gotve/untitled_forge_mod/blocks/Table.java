package com.gotve.untitled_forge_mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Table extends Block {

    // shapes generated from oak_table.json
    private static final VoxelShape LEG_RF = Block.box(14, 0, 0, 16, 10, 2);
    private static final VoxelShape TOP     = Block.box(0, 10, 0, 16, 12, 16);
    private static final VoxelShape LEG_LF = Block.box(0, 0, 0, 2, 10, 2);
    private static final VoxelShape LEG_LB = Block.box(0, 0, 14, 2, 10, 16);
    private static final VoxelShape LEG_RB = Block.box(14, 0, 14, 16, 10, 16);

    // used to bundle all custom models and pass to getShape
    private static final VoxelShape SHAPE = Shapes.or(
            LEG_RF,
            TOP,
            LEG_LF,
            LEG_LB,
            LEG_RB
    );

    public Table(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        player.sendSystemMessage(Component.literal("You've knocked on a table"));
        return InteractionResult.SUCCESS;
    }
}
