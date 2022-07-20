package com.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Ingredient can NOT be blank!")
    @Size(min = 3, max = 50, message = "Must be between 3 to 50 characters!")
    private String name;

    @ManyToMany
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
    
    public List<Recipe> getRecipe() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
