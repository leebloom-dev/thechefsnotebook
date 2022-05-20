package com.thechefsnotebook.thechefsnotebook.model;

public class RecipesModel {

    /* FIELD */
    
    private int id;
    private static int nextId = 1;
    private String recipeName;

    
    /* CONSTRUCTORS */
    
    public RecipesModel() {

    }

    public RecipesModel(String recipeName) {
        this.id = nextId;
        this.recipeName = recipeName;
        nextId++;
    }
    

    /* METHODS: GETTERS AND SETTERS */

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
}
