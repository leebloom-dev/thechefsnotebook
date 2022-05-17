package com.thechefsnotebook.thechefsnotebook.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thechefsnotebook.thechefsnotebook.model.Recipe;

public class RecipeData {

    // holds a list of key/value pairs.
    private static Map<Integer, Recipe> recipes = new HashMap<>();

    // returns a collection of values contained this map. 
    public static Collection<Recipe> getAll() {
        return recipes.values();
    }

    // returns a specific Recipe by getting the HashMap key.
    public static Recipe getById(Integer id) {
        return recipes.get(id);
    }

    // Adding key/value to map where key: id and value: contact informationß
    public static void add(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
    }

    // using the 'key to remove the key/value pair in the map 
    public static void remove(Integer id) {
        if (recipes.containsKey(id)) {
            recipes.remove(id);
        }
    }
    
}
