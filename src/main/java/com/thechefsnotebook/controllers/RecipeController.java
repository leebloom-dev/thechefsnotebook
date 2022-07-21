package com.thechefsnotebook.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.thechefsnotebook.data.RecipeCategoryRepository;
import com.thechefsnotebook.data.RecipeCuisineRepository;
import com.thechefsnotebook.data.RecipeRepository;
import com.thechefsnotebook.models.Recipe;
import com.thechefsnotebook.models.RecipeCategory;
import com.thechefsnotebook.models.RecipeCuisine;

@Controller
@RequestMapping("recipes") // URL "localhost:8080/recipes"
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCuisineRepository recipeCuisineRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    // responds to GET requests at URL "/recipes"
    @GetMapping
    public String displayRecipes(@RequestParam(required = false) Integer categoryId,
                                 @RequestParam(required = false) Integer cuisineId,
                                 @RequestParam(required = false) String type,
                                 Model model) {

        // Request Parameter filters table of specific category.
        if (type.equals("category")) {
            if (categoryId == null) {
                model.addAttribute("title", "All Recipes");
                model.addAttribute("recipes", recipeRepository.findAll());
            } else {
                Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
                if (result.isEmpty()) {
                    model.addAttribute("title", "Invalid Category ID: " + categoryId);
                } else {
                    RecipeCategory category = result.get();
                    model.addAttribute("title", category.getName() + " Recipes");
                    model.addAttribute("recipes", category.getRecipes());
                }
            }
            return "recipes/index";
        }
        
        // Request Parameter filters table of specific cuisine.
        if (type.equals("cuisine")) {
            if (cuisineId == null) {
                model.addAttribute("title", "All Recipes");
                model.addAttribute("recipes", recipeRepository.findAll());
            } else {
                Optional<RecipeCuisine> result = recipeCuisineRepository.findById(cuisineId);
                if (result.isEmpty()) {
                    model.addAttribute("title", "Invalid Cuisine ID: " + cuisineId);
                } else {
                    RecipeCuisine cuisine = result.get();
                    model.addAttribute("title", cuisine.getName() + " Recipes");
                    model.addAttribute("recipes", cuisine.getRecipes());
                }
            }
            return "recipes/index";
        }
        
        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }
    
    // responds to GET requests at URL "/recipes/create"
    @GetMapping("create")
    public String displayRecipeForm(Model model) {
        model.addAttribute("title", "Recipe Form Page");
        model.addAttribute("recipe", new Recipe()); // same names: variable & class
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        model.addAttribute("recipeCuisines", recipeCuisineRepository.findAll());
        
        return "recipes/create";
    }
    
    // responds to POST requests at URL "/recipes/create"
    @PostMapping("create")
    public String processRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model) {
        
        // error validation if true
        if (errors.hasErrors()) {
            model.addAttribute("title", "Recipe Form Page");
            model.addAttribute("recipeCuisines", recipeCategoryRepository.findAll());
            model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
            return "recipes/create";
        }
        
        // add recipe name to the array list
        recipeRepository.save(newRecipe);

        // redirect to URL "/recipes"
        return "redirect:?type=none";

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
        return "redirect:?type=none";

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
    public String processSearchForm(@RequestParam(required = false) String recipeSearch, Model model) {
        
        List<Recipe> recipes = new ArrayList<>();
        
        for (Recipe recipe : recipeRepository.findAll()) {
            if (recipe.getName().toUpperCase().equals(recipeSearch.toUpperCase())) {
                recipes.add(recipe);
            }
        }
        
        model.addAttribute("title", "Search Recipes");
        model.addAttribute("recipes", recipes);
        return "recipes/search";
    }

    // Responds to GET requets at '/recipes/selected-recipe'
    @GetMapping("selected-recipe")
    public String renderSelectedRecipe(@RequestParam Integer recipeId, Model model) {
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        Recipe recipe = result.get();
        model.addAttribute("title", "Recipe: " + recipe.getName());
        model.addAttribute("recipe", recipe);
        return "recipes/selected-recipe";
    }

}
