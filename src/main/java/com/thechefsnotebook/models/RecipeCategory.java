package com.thechefsnotebook.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class RecipeCategory extends AbstractEntity {
    
    @NotBlank(message = "The recipe category can not be blank!")
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    public RecipeCategory(String name) {
        this.name = name;
    }

    public RecipeCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 }
