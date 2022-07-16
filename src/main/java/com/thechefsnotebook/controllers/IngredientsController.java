package com.thechefsnotebook.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thechefsnotebook.data.RecipeRepository;
import com.thechefsnotebook.models.Recipe;

@Controller
@RequestMapping("ingredients") // URL: localhost:8080/ingredients
public class IngredientsController {

    @Autowired
    RecipeRepository recipeRepository;

    // Responds to GET requests at '/ingredients'
    @GetMapping
    public String displayIngredients(Model model) {
        model.addAttribute("title", "Ingredients");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "ingredients/index";
    }
    
    // Responds to GET requests at "'/ingredients/create?recipeId=' + ${recipe.id}"
    @GetMapping("create")
    public String renderIngredientForm(@RequestParam Integer recipeId, Model model) {
        Optional <Recipe> result = recipeRepository.findById(recipeId);
        Recipe recipe = result.get();
        model.addAttribute("title", "Create Ingredients: " + recipe.getName());
        return "ingredients/create";
    }

}