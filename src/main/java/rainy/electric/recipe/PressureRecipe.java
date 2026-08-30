package rainy.electric.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record PressureRecipe(Ingredient inputItem, ItemStack output) implements Recipe<PressureRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;

    }

    @Override
    public boolean matches(PressureRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(PressureRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PRESSURE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.PRESSURE_TYPE;
    }


    public static class Serializer implements RecipeSerializer<PressureRecipe> {
        public static final MapCodec<PressureRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(PressureRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(PressureRecipe::output)
        ).apply(inst, PressureRecipe::new));

                public static final PacketCodec<RegistryByteBuf, PressureRecipe> STREAM_CODEC =
                        PacketCodec.tuple(
                                Ingredient.PACKET_CODEC, PressureRecipe::inputItem,
                                ItemStack.PACKET_CODEC, PressureRecipe::output,
                                PressureRecipe::new
                        );

        @Override
        public MapCodec<PressureRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, PressureRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }


}
