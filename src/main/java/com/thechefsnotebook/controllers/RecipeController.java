package com.thechefsnotebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipes") // root URL: "localhost:8080/"
public class RecipeController {

    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "Recipes Home Page");
        return "/recipes/index"; // file path to HTML
    }
    
}
