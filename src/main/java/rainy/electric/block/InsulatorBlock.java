package rainy.electric.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rainy.electric.entity.InsulatorBlockEntity;

public class InsulatorBlock extends BlockWithEntity {

     public static final MapCodec<InsulatorBlock> CODEC = InsulatorBlock.createCodec(InsulatorBlock::new);

    public InsulatorBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new InsulatorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof InsulatorBlockEntity) {
                ItemScatterer.spawn(world, pos, ((InsulatorBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof InsulatorBlockEntity insulator) {
            if (world.isClient) {
                return ItemActionResult.SUCCESS;
            }

            if (insulator.isEmpty() && !stack.isEmpty()) {
                ItemStack toStore = stack.copy();
                toStore.setCount(1);
                insulator.setStack(0, toStore);

                stack.decrement(1);

                world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                insulator.markDirty();
                world.updateListeners(pos, state, state, 3);
            } else if (stack.isEmpty() && !player.isSneaking()) {
                ItemStack stackOnInsulator = insulator.getStack(0).copy();
                if (!stackOnInsulator.isEmpty()) {
                    player.setStackInHand(hand, stackOnInsulator);
                    insulator.clear();

                    world.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    insulator.markDirty();
                    world.updateListeners(pos, state, state, 3);

            }
        }}

    return ItemActionResult.SUCCESS;

    }}

