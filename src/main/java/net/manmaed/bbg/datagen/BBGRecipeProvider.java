package net.manmaed.bbg.datagen;

import net.manmaed.bbg.items.BBGItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BBGRecipeProvider extends RecipeProvider {

    private static final RecipeCategory tools = RecipeCategory.TOOLS;
    public BBGRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(tools, BBGItems.BEDROCK_PICKAXE.get())
                .define('o', Ingredient.of(Blocks.OBSIDIAN))
                .define('p', Ingredient.of(Items.DIAMOND_PICKAXE))
                .pattern("ooo")
                .pattern("opo")
                .pattern("ooo")
                .unlockedBy("has_diamond_pickaxe", has(Items.DIAMOND_PICKAXE)).save(recipeOutput);
    }
}
