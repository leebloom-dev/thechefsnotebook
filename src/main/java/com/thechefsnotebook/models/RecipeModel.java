package com.thechefsnotebook.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RecipeModel {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Must give a recipe name!")
    // Size in characters
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
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
