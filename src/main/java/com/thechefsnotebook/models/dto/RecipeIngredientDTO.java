package com.thechefsnotebook.models.dto;

import javax.validation.constraints.NotNull;

import com.thechefsnotebook.models.Ingredient;
import com.thechefsnotebook.models.Recipe;

/*
 * This Data Transfer Object (DTO) will enable other multiple objects or 
 * values to be passed around with the application, in a single container.
 * We want to utilize DTO to hold Recipe and Ingredient instances that we 
 * want to relate to each other.
 * 
 * This DTO will contain two fields, no constructors, and accessors for 
 * the fields.
 * 
 * This DTO is placed in a seperate package within the Model package because
 * this DTO is a model that structures data that the application uses. 
 * @Entity is excluded because we don't need to store it in the database.
 * 
 */
public class RecipeIngredientDTO {

    @NotNull
    private Recipe recipe;
    
    @NotNull
    private Ingredient ingredient;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    
}
