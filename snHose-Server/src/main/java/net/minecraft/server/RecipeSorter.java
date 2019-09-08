package net.minecraft.server.v1_7_R4;

import java.util.*;

class RecipeSorter implements Comparator
{
    final /* synthetic */ CraftingManager a;
    
    RecipeSorter(final CraftingManager a) {
        this.a = a;
    }
    
    public int a(final IRecipe recipe, final IRecipe recipe2) {
        if (recipe instanceof ShapelessRecipes && recipe2 instanceof ShapedRecipes) {
            return 1;
        }
        if (recipe2 instanceof ShapelessRecipes && recipe instanceof ShapedRecipes) {
            return -1;
        }
        if (recipe2.a() < recipe.a()) {
            return -1;
        }
        if (recipe2.a() > recipe.a()) {
            return 1;
        }
        return 0;
    }
}
