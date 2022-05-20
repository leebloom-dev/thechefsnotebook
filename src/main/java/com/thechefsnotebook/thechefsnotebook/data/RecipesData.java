package com.thechefsnotebook.thechefsnotebook.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thechefsnotebook.thechefsnotebook.model.RecipesModel;

public class RecipesData {

    // Stores key-value pairs (recipe id, recipe object)
    private static final Map<Integer, RecipesModel> recipes = new HashMap<>();

    // returns the values in HashMap recipes
    public static Collection<RecipesModel> getAll() {
        return recipes.values();
    }

    // add a recipe to the HashMap
    public static void add(RecipesModel recipesModel) {
        recipes.put(recipesModel.getId(), recipesModel); // new RecipesModel(@RequestParam String recipeName)
    }

    // get recipe id
    public static RecipesModel getById(Integer id) {
        return recipes.get(id);
    }

    // remove a recipe using the recipe id
    public static void remove(Integer id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
        }
    }
    
}
