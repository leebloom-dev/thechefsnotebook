package com.thechefsnotebook.models;

public class RecipeModel {

    private int id;
    private static int nextId = 1;
    private String name;

    public RecipeModel(String name) {
        this();
        this.name = name;
    }

    public RecipeModel() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
