package com.thechefsnotebook.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Recipe {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Must give a recipe name!")
    // Size in characters
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    public Recipe(String name) {
        this();
        this.name = name;
    }

    public Recipe() {
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
    
    // @Override
    // public String toString() {
    //     return name;
    // }

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Event event = (Event) o;
    //     return id == event.id;
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id);
    // }
}