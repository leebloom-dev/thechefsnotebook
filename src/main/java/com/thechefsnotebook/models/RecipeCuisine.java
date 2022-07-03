package com.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecipeCuisine extends AbstractEntity {
    
    @NotBlank(message = "Must create a cuisine!")
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    // Relationship between one cuisine to many recipes
    @OneToMany(mappedBy = "recipeCuisine")
    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeCuisine(String name) {
        this.name = name;
    }

    public RecipeCuisine() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

}