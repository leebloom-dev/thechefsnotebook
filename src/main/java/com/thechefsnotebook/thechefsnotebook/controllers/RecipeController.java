package com.thechefsnotebook.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipes") // URL "localhost:8080/recipes"
public class RecipeController {
    
    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayRecipeHomePage(Model model) {
        model.addAttribute("title", "Recipe Home Page");
        return "recipes/index";
    }

}
