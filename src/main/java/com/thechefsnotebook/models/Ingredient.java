package com.thechefsnotebook.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Ingredient can NOT be blank!")
    @Size(min = 3, max = 50, message = "Must be between 3 to 50 characters!")
    private String name;

    @ManyToOne
    private Recipe recipe;

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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return name;
    }

}
