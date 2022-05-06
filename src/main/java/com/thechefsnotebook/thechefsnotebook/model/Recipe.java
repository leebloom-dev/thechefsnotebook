package com.thechefsnotebook.thechefsnotebook.model;

public class Recipe {

    private int id;
    private int nextId = 1;

    private String name;
    private String description;

    public Recipe(String name, String description) {
        this.id = nextId;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
