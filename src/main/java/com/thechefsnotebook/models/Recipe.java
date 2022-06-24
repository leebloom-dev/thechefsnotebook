package com.thechefsnotebook.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank(message = "Must give a recipe name!")  // Size in characters
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    @NotBlank(message = "Must select a cuisine!")
    private String cuisine;

    public Recipe(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
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
    
    @Override
    public String toString() {
        return name;
    }

}
