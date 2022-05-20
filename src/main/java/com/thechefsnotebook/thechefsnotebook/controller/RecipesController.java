package com.thechefsnotebook.thechefsnotebook.controller;

import com.thechefsnotebook.model.RecipesModel;
import com.thechefsnotebook.thechefsnotebook.data.RecipesData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("recipes") // root URL path for the controller methods "localhost:8080/"
public class RecipesController {

    // responds to GET requests at "/recipes"
    @GetMapping
    public String renderRecipePage(Model model) {
        // adding the array list to the model attribute.
        model.addAttribute("recipes", RecipesData.getAll());

        // file path to HTML
        return "recipes/recipes";
    }

    // responds to GET requests at "/recipes/form"
    @GetMapping("form")
    public String renderRecipeForm() {
        return "recipes/form";
    }

    // responds to POST requests at "/recipes/form"
    @PostMapping("form")
    public String processRecipeForm(@RequestParam String recipeName) {
        // adding recipe object to empty HashMap
        RecipesData.add(new RecipesModel(recipeName));

        // redirects to URL root path "/recipes"
        return "redirect:";
    }

    // responds to GET requests at "/recipes/remove"
    @GetMapping("remove")
    public String renderRecipeRemoveForm(Model model) {
        model.addAttribute("recipes", RecipesData.getAll());
        return "recipes/remove";
    }

    // responds to POST requests at "/recipes/remove"
    @PostMapping("remove")
    public String processRecipeRemoveForm(@RequestParam(required = false) int[] recipeIds) {
        // if the recipes id array is not null
        if (recipeIds != null) {
            // for each id in the array of recipe ids
            for (int id : recipeIds) {
                RecipesData.remove(id);
            }
        }

        // redirects to the root URL path in this class
        return "redirect:";
    }
    
}
