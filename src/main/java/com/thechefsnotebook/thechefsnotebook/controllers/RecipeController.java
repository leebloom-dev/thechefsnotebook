package com.thechefsnotebook.thechefsnotebook.controllers;

import com.thechefsnotebook.thechefsnotebook.data.RecipeData;
import com.thechefsnotebook.thechefsnotebook.model.Recipe;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("recipe")
public class RecipeController {

    // Lives at "/recipe"
    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/recipe";
    }
    
    // Lives at "/recipe"
    @PostMapping
    public String createRecipe( @RequestParam String recipeName, 
                                @RequestParam String cuisineType,
                                Model model) {

        // add user input to Recipe Data
        RecipeData.add(new Recipe(recipeName, cuisineType));
        return "redirect:/recipe"; // redirect to "/recipe"

    }

    // Lives at "/recipe/delete"
    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("recipes", RecipeData.getAll());
        return "recipes/delete";
    }

    // Lives at "/recipe/delete"
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
