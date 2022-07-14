package com.thechefsnotebook.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Ingredient can NOT be blank!")
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
