package com.thechefsnotebook.thechefsnotebook.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is required.") // message displayed in Whitelabel error page
    @Size(min = 3, max = 50, message = "Name must be within 3 to 50 characters.")
    private String recipeName;

    @NotBlank(message = "Nmae is required.")
    @Size(min = 3, max = 50, message = "name must be within 3 to 50 characters.")
    private String cuisineType;

    public Recipe(String recipeName, String cuisineType) {
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
 
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Override
    public String toString() {
        return recipeName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Recipe recipe = (Recipe) obj;
        return id == recipe.id;
    }

}
