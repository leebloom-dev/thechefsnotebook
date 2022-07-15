package com.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ingredients") // URL: localhost:8080/ingredients
public class IngredientsController {

    // Responds to GET requests at '/ingredients'
    @GetMapping
    public String displayIngredients(@RequestParam Integer recipeId, @RequestParam String recipeName, Model model) {
        model.addAttribute("title", "Recipe #" + recipeId + ": " + recipeName);
        return "ingredients/index";
    }
    
}