package com.thechefsnotebook.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thechefsnotebook.models.RecipeModel;

public class RecipeData {

    private static final Map<Integer, RecipeModel> recipes = new HashMap<>();

    // get all recipes
    public static Collection<RecipeModel> getAll() {
        return recipes.values();
    }

    // add recipe
    public static void add(RecipeModel newRecipe) {
        recipes.put(newRecipe.getId(), newRecipe);
    }

    // remove recipe
    public static void delete(int id) {
        recipes.remove(id);
    }
    
}
