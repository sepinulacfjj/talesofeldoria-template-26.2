package net.sepinula.talesofeldoria.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Tales Of Eldoria Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERDIGRIS_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.VERDIGRIS.get())
                .unlockedBy(getHasName(ModItems.VERDIGRIS.get()), has(ModItems.VERDIGRIS))
                .group("verdigris")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.VERDIGRIS.get(), 9)
                .requires(ModBlocks.VERDIGRIS_BLOCK)
                .unlockedBy(getHasName(ModBlocks.VERDIGRIS_BLOCK.get()), has(ModBlocks.VERDIGRIS_BLOCK))
                .group("verdigris")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.VERDIGRIS.get(), 18)
                .requires(ModBlocks.VERDIGRIS_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModBlocks.VERDIGRIS_BLOCK.get()), has(ModBlocks.VERDIGRIS_BLOCK))
                .group("verdigris")
                .save(output, "talesofeldoria:verdigris_from_blaze_powder");

        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_VERDIGRIS, ModBlocks.VERDIGRIS_ORE,
                ModBlocks.VERDIGRIS_DEEPSLATE_ORE, ModBlocks.VERDIGRIS_NETHER_ORE, ModBlocks.VERDIGRIS_END_ORE);

        oreSmelting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VERDIGRIS.get(), 0.25f, 200, "verdigris");
        oreBlasting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VERDIGRIS.get(), 0.25f, 100, "verdigris");
        }
    }