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
    public String createRecipe( @RequestParam String name, 
                                @RequestParam String description,
                                Model model) {

        // add user input to Recipe Data
        RecipeData.add(new Recipe(name, description));
        return "redirect:/recipe"; // redirect to "/recipe"

    }
}
