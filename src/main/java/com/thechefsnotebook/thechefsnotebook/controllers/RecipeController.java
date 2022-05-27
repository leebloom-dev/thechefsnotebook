package com.thechefsnotebook.thechefsnotebook.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("recipes") // URL "localhost:8080/recipes"
public class RecipeController {

    private List<String> recipes = new ArrayList<>();
    
    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayRecipeHomePage(Model model) {
        model.addAttribute("title", "Recipe Home Page");

        // add list to the model
        model.addAttribute("recipes", recipes);

        return "recipes/index";
    }

    // responds to GET requests at URL "/recipes/form"
    @GetMapping("create")
    public String displayRecipeForm(Model model) {
        model.addAttribute("title", "Recipe Form Page");
        return "recipes/form";
    }

    // responds to POST requests at URL "/recipes/form"
    @PostMapping("create")
    public String processRecipeForm(@RequestParam String name) {
        
        // add recipe name to the array list
        recipes.add(name);
        
        // redirect to URL "/recipes"
        return "redirect:";

    }

}
