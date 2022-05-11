package com.thechefsnotebook.thechefsnotebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    private String recipeName;
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

}
