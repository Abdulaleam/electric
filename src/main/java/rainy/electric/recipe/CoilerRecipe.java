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

public record CoilerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CoilerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;

    }

    @Override
    public boolean matches(CoilerRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CoilerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipes.COILER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COILER_TYPE;
    }


    public static class Serializer implements RecipeSerializer<CoilerRecipe> {
        public static final MapCodec<CoilerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CoilerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CoilerRecipe::output)
        ).apply(inst, CoilerRecipe::new));

                public static final PacketCodec<RegistryByteBuf, CoilerRecipe> STREAM_CODEC =
                        PacketCodec.tuple(
                                Ingredient.PACKET_CODEC, CoilerRecipe::inputItem,
                                ItemStack.PACKET_CODEC, CoilerRecipe::output,
                                CoilerRecipe::new
                        );

        @Override
        public MapCodec<CoilerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CoilerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }


}
