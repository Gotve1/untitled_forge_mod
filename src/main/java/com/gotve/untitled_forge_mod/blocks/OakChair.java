package com.gotve.untitled_forge_mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class OakChair extends Block {

    private static final VoxelShape LEG_NW = Block.box(3, 0, 3, 5, 5, 5);
    private static final VoxelShape LEG_NE = Block.box(11, 0, 3, 13, 5, 5);
    private static final VoxelShape LEG_SW = Block.box(3, 0, 11, 5, 5, 13);
    private static final VoxelShape LEG_SE = Block.box(11, 0, 11, 13, 5, 13);

    private static final VoxelShape SEAT = Block.box(3, 5, 3, 13, 7, 13);

    private static final VoxelShape SHAPE = Shapes.or(
            LEG_NW,
            LEG_NE,
            LEG_SW,
            LEG_SE,
            SEAT
    );

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public OakChair(Properties properties) {
        super(properties);
        //this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (!level.isClientSide) {

            if (!player.isPassenger()) {

                List<ArmorStand> stands = level.getEntitiesOfClass(ArmorStand.class, new AABB(pos).inflate(0.2));

                for (ArmorStand s : stands) {
                    byte f = s.getEntityData().get(ArmorStand.DATA_CLIENT_FLAGS);
                    boolean isSeat = (f & 16) != 0 && (f & 1) != 0;
                    if (isSeat) {
                        player.startRiding(s, true);
                        return InteractionResult.sidedSuccess(false);
                    }
                }

                ArmorStand seat = new ArmorStand(EntityType.ARMOR_STAND, level);
                Direction facing = state.getValue(FACING);

                float yaw;
                switch (facing) {
                    case NORTH -> yaw = 180f;
                    case SOUTH -> yaw = 0f;
                    case WEST  -> yaw = 90f;
                    case EAST  -> yaw = -90f;
                    default -> yaw = 0f;
                }

                seat.setInvisible(true);
                seat.setNoGravity(true);
                seat.setYRot(yaw);
                seat.setXRot(0);

                byte flags = seat.getEntityData().get(ArmorStand.DATA_CLIENT_FLAGS);
                flags |= 16;
                flags |= 1;
                seat.getEntityData().set(ArmorStand.DATA_CLIENT_FLAGS, flags);

                seat.setPos(pos.getX() + 0.5, pos.getY() + 0.20, pos.getZ() + 0.5);

                level.addFreshEntity(seat);
                player.startRiding(seat, true);
                player.setYRot(yaw);
                player.setXRot(0);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {

        // Only run when the block is actually being replaced by air or another block
        if (!state.is(newState.getBlock())) {

            AABB box = new AABB(pos).inflate(0.5);

            level.getEntitiesOfClass(ArmorStand.class, box).forEach(stand -> {
                byte flags = stand.getEntityData().get(ArmorStand.DATA_CLIENT_FLAGS);

                boolean isMarker = (flags & 16) != 0;
                boolean isSmall = (flags & 1) != 0;

                // Only delete your seat ArmorStands
                if (isMarker && isSmall && stand.isInvisible()) {
                    stand.discard();
                }
            });
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

}
