package com.thechefsnotebook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thechefsnotebook.data.CuisineData;
import com.thechefsnotebook.data.RecipeRepository;
import com.thechefsnotebook.models.Recipe;

@Controller
@RequestMapping("recipes") // URL "localhost:8080/recipes"
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayRecipeHomePage(Model model) {
        model.addAttribute("title", "Recipe Home Page");

        // add list of recipes to the model
        model.addAttribute("recipes", recipeRepository.findAll());

        return "recipes/index";
    }

    // responds to GET requests at URL "/recipes/create"
    @GetMapping("create")
    public String displayRecipeForm(Model model) {
        model.addAttribute("title", "Recipe Form Page");
        model.addAttribute("recipe", new Recipe()); // same names: variable & class

        // add sorted ascending list(String) of cuisines to the model
        model.addAttribute("cuisines", CuisineData.getAll());

        return "recipes/create";
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
            return "recipes/create";
        }
        
        // add recipe name to the array list
        recipeRepository.save(newRecipe);
        
        // redirect to URL "/recipes"
        return "redirect:";

    }

    // responds to GET requests at URL "/recipes/delete"
    @GetMapping("delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title", "Delete Recipe Form");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/delete";
    }

    // responds to POST requests at URL "/recipes/delete"
    @PostMapping("delete")
    public String processDeleteForm(@RequestParam (required = false) int[] recipeIds) {

        // if int array is not empty
        if (recipeIds != null) {
            for (int id : recipeIds) {
                recipeRepository.deleteById(id);
            }
        }

        // redirect to URL "/recipes"
        return "redirect:";

    }

    // responds to GET requests at URL "/recipes/search"
    @GetMapping("search")
    public String displaySearchForm(Model model) {
        model.addAttribute("title", "Search Recipes");
        model.addAttribute("recipe", new Recipe());
        return "recipes/search";
    }

    // responds to POST requests at URL "/recipes/search"
    @PostMapping("search")
    public String processSearchForm(@ModelAttribute @Valid Recipe recipe,
                                    Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Search Recipes");
            return "recipes/search";
        }

        return "recipes/search";
    }

}
