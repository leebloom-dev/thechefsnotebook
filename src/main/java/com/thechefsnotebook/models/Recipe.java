package com.thechefsnotebook.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank(message = "Must give a recipe name!")  // Size in characters
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    @NotBlank(message = "Must select a cuisine!")
    private String cuisine;

    @ManyToOne
    @NotNull(message = "A recipe category is required! Please create a category...")
    private RecipeCategory recipeCategory;

    public Recipe(String name, String cuisine, RecipeCategory recipeCategory) {
        this.name = name;
        this.cuisine = cuisine;
        this.recipeCategory = recipeCategory;
    }

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
