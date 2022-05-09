package com.thechefsnotebook.thechefsnotebook.model;

public class Recipe {

    private int id;
    private int nextId = 1;

    private String recipeName;
    private String cuisineType;

    public Recipe(String recipeName, String cuisineType) {
        this.id = nextId;
        this.recipeName = recipeName;
        this.cuisineType = cuisineType;
        nextId++;
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
