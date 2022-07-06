package com.thechefsnotebook.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.thechefsnotebook.data.enumSearchType.Type;

@Entity
public class RecipeCategory extends AbstractEntity {
    
    @NotBlank(message = "The recipe category can not be blank!")
    @Size(min = 3, max = 50, message = "Must be within 3 to 50 characters!")
    private String name;

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();

    private final String TYPE = Type.CATEGORY.getType();

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

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public String getTYPE() {
        return TYPE;
    }

 }
