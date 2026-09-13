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
import net.minecraft.world.level.block.Blocks;
import net.sepinula.talesofeldoria.TalesOfEldoria;
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
        // --- VERDIGRIS RECIPES ---

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
                .save(output, TalesOfEldoria.MOD_ID + ":verdigris_from_blaze_powder");

        List<ItemLike> VERDIGRIS_SMELTABLES = List.of(ModItems.RAW_VERDIGRIS, ModBlocks.VERDIGRIS_ORE,
                ModBlocks.VERDIGRIS_DEEPSLATE_ORE, ModBlocks.VERDIGRIS_NETHER_ORE, ModBlocks.VERDIGRIS_END_ORE);

        oreSmelting(VERDIGRIS_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VERDIGRIS.get(), 0.25f, 200, "verdigris");
        oreBlasting(VERDIGRIS_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.VERDIGRIS.get(), 0.25f, 100, "verdigris");

        // --- WOOD CRAFTING RECIPES ---

        // Log -> 4 Planks
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERDANT_PLANK.get(), 4)
                .requires(ModBlocks.VERDANT_LOG.get())
                .unlockedBy(getHasName(ModBlocks.VERDANT_LOG.get()), has(ModBlocks.VERDANT_LOG.get()))
                .group("planks")
                .save(output, TalesOfEldoria.MOD_ID + ":verdant_planks_from_log");

        // Stripped Log -> 4 Planks
        shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VERDANT_PLANK.get(), 4)
                .requires(ModBlocks.VERDANT_STRIPPED_LOG.get())
                .unlockedBy(getHasName(ModBlocks.VERDANT_STRIPPED_LOG.get()), has(ModBlocks.VERDANT_STRIPPED_LOG.get()))
                .group("planks")
                .save(output, TalesOfEldoria.MOD_ID + ":verdant_planks_from_stripped_log");

        // Planks -> Sticks
        shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("A")
                .pattern("A")
                .define('A', ModBlocks.VERDANT_PLANK.get())
                .unlockedBy(getHasName(ModBlocks.VERDANT_PLANK.get()), has(ModBlocks.VERDANT_PLANK.get()))
                .group("sticks")
                .save(output, TalesOfEldoria.MOD_ID + ":sticks_from_verdant_planks");

        // Planks -> Crafting Table
        shaped(RecipeCategory.DECORATIONS, Blocks.CRAFTING_TABLE)
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.VERDANT_PLANK.get())
                .unlockedBy(getHasName(ModBlocks.VERDANT_PLANK.get()), has(ModBlocks.VERDANT_PLANK.get()))
                .save(output, TalesOfEldoria.MOD_ID + ":crafting_table_from_verdant_planks");

        // --- WOOD SMELTING (CHARCOAL) ---

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.VERDANT_LOG.get()),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        Items.CHARCOAL,
                        0.15f,
                        200
                ).unlockedBy(getHasName(ModBlocks.VERDANT_LOG.get()), has(ModBlocks.VERDANT_LOG.get()))
                .save(output, TalesOfEldoria.MOD_ID + ":charcoal_from_verdant_log");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.VERDANT_STRIPPED_LOG.get()),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        Items.CHARCOAL,
                        0.15f,
                        200
                ).unlockedBy(getHasName(ModBlocks.VERDANT_STRIPPED_LOG.get()), has(ModBlocks.VERDANT_STRIPPED_LOG.get()))
                .save(output, TalesOfEldoria.MOD_ID + ":charcoal_from_verdant_stripped_log");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for (ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TalesOfEldoria.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}