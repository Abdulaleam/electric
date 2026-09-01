package rainy.electric.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rainy.electric.entity.CoilerBlockEntity;
import rainy.electric.entity.ModBlockEntities;

public class CoilerBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<CoilerBlock> CODEC = CoilerBlock.createCodec(CoilerBlock::new);

    protected CoilerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CoilerBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(
            BlockState state,
            World world,
            BlockPos pos,
            BlockState newState,
            boolean moved
    ) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof CoilerBlockEntity) {
                ItemScatterer.spawn(world, pos, (CoilerBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(
            ItemStack stack,
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult hit
    ) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof CoilerBlockEntity) {
                NamedScreenHandlerFactory screenHandlerFactory =
                        (NamedScreenHandlerFactory) blockEntity;

                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ItemActionResult.SUCCESS;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            World world,
            BlockState state,
            BlockEntityType<T> type
    ) {
        if (world.isClient()) {
            return null;
        }

        return validateTicker(
                type,
                ModBlockEntities.COILER_BE,
                (world1, pos, state1, blockEntity) ->
                        blockEntity.tick(world1, pos, state1)
        );
    }
}