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
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record InsulatorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<InsulatorRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }


    @Override
    public boolean matches(InsulatorRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(InsulatorRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.INSULATOR_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.INSULATOR_TYPE;
    }

    public static class Serializer implements RecipeSerializer<InsulatorRecipe> {
        public static final MapCodec<InsulatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(InsulatorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(InsulatorRecipe::output)
        ).apply(inst, InsulatorRecipe::new));
        public static final PacketCodec<RegistryByteBuf, InsulatorRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, InsulatorRecipe::inputItem,
                        ItemStack.PACKET_CODEC, InsulatorRecipe::output,
                        InsulatorRecipe::new
                );

        @Override
        public MapCodec<InsulatorRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, InsulatorRecipe> packetCodec() {
            return STREAM_CODEC;
        }

    }


}
