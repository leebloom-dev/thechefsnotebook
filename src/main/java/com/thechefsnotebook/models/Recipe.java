package com.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank(message = "Must give a recipe name!")  // Size in characters
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    @ManyToOne
    @NotNull(message = "A cuisine is Required! Please create a cuisine...")
    private RecipeCuisine recipeCuisine;
    
    @ManyToOne
    @NotNull(message = "A category is required! Please create a category...")
    private RecipeCategory recipeCategory;
    
    @OneToMany(mappedBy = "name")
    private final List<Ingredient> ingredients = new ArrayList<>();
    

    public Recipe(String name, RecipeCuisine recipeCuisine, RecipeCategory recipeCategory) {
        this.name = name;
        this.recipeCuisine = recipeCuisine;
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

    public RecipeCuisine getRecipeCuisine() {
        return recipeCuisine;
    }

    public void setRecipeCuisine(RecipeCuisine recipeCuisine) {
        this.recipeCuisine = recipeCuisine;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
