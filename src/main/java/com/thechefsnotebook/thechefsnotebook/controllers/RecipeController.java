package com.thechefsnotebook.thechefsnotebook.controllers;

import javax.validation.Valid;

import com.thechefsnotebook.thechefsnotebook.data.RecipeData;
import com.thechefsnotebook.thechefsnotebook.model.Recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    // responds to GET requests at "/recipe"
    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/recipe";
    }
    
    // responds to GET requests at "/recipe/form"
    @GetMapping("form")
    public String renderRecipeForm(Model model) {
        model.addAttribute("Title", "Recipe Form");
        return "recipes/form";
    }

    // responds to POST requests at "/recipe/form"
    @PostMapping("form")
    public String processRecipeForm(@ModelAttribute @Valid Recipe newRecipe,
                                    Errors errors,
                                    Model model) {

        // Handles validation errors by preventing validation exception.
        if (errors.hasErrors()) {
            model.addAttribute("Title", "Recipe Form");
            model.addAttribute("errorMsg", "Bad data!");
            return "recipes/form";
        }

        // Using @ModelAttribute instead of @RequestParam to pass user input into the Recipe object.
        // Passed input goes through the object's constructor. Field names must match HTML name
        // attribute.
        RecipeData.add(newRecipe);
        return "redirect:"; // redirect to "/recipe"

    }

    // responds to GET requests at "/recipe/delete"
    @GetMapping("delete")
    public String renderDeleteRecipeForm(Model model) {
        model.addAttribute("Title", "Delete Recipe");
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/delete";
    }

    // responds to POST requests at "/recipe/delete"
    @PostMapping("delete")
    public String processDeleteRecipeForm(@RequestParam (required = false) int[] recipeIds) {

        if (recipeIds != null) {
            for (int id : recipeIds) {
                RecipeData.remove(id);
            }
        }

        return "redirect:/recipe";
    }
}
