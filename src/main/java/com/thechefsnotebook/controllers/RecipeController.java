package com.thechefsnotebook.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thechefsnotebook.data.CuisineData;
import com.thechefsnotebook.data.RecipeData;
import com.thechefsnotebook.models.Recipe;

@Controller
@RequestMapping("recipes") // URL "localhost:8080/recipes"
public class RecipeController {

    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayRecipeHomePage(Model model) {
        model.addAttribute("title", "Recipe Home Page");

        // add list of recipes to the model
        model.addAttribute("recipes", RecipeData.getAll());

        return "recipes/index";
    }

    // responds to GET requests at URL "/recipes/create"
    @GetMapping("create")
    public String displayRecipeForm(Model model) {
        model.addAttribute("title", "Recipe Form Page");
        model.addAttribute("recipe", new Recipe()); // same names: variable & class

        // add list of cuisines to the model
        model.addAttribute("cuisines", CuisineData.getAll());

        return "recipes/form";
    }

    // responds to POST requests at URL "/recipes/create"
    @PostMapping("create")
    public String processRecipeForm(@ModelAttribute @Valid Recipe newRecipe, 
                                    Errors errors, Model model) {

        // error validation if true
        // Model name can NOT have camel case!!!
        if (errors.hasErrors()) {
            model.addAttribute("title", "Recipe Form Page");
            model.addAttribute("cuisines", CuisineData.getAll());
            return "recipes/form";
        }
        
        // add recipe name to the array list
        RecipeData.add(newRecipe);
        
        // redirect to URL "/recipes"
        return "redirect:";

    }

    // responds to GET requests at URL "/recipes/delete"
    @GetMapping("delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title", "Delete Recipe Form");
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/delete";
    }

    // responds to POST requests at URL "/recipes/delete"
    @PostMapping("delete")
    public String processDeleteForm(@RequestParam (required = false) int[] recipeIds) {

        // if int array is not empty
        if (recipeIds != null) {
            for (int id : recipeIds) {
                RecipeData.delete(id);
            }
        }

        // redirect to URL "/recipes"
        return "redirect:";

    }

}
