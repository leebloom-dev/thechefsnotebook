package com.thechefsnotebook.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thechefsnotebook.models.Recipe;

public class RecipeData {

    private static final Map<Integer, Recipe> recipes = new HashMap<>();

    // get all recipes
    public static Collection<Recipe> getAll() {
        return recipes.values();
    }

    // add recipe
    public static void add(Recipe newRecipe) {
        recipes.put(newRecipe.getId(), newRecipe);
    }

    // remove recipe
    public static void delete(int id) {
        recipes.remove(id);
    }
    
}
