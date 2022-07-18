package com.thechefsnotebook.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thechefsnotebook.data.IngredientRepository;
import com.thechefsnotebook.data.RecipeRepository;
import com.thechefsnotebook.models.Ingredient;
import com.thechefsnotebook.models.Recipe;

@Controller
@RequestMapping("ingredients") // URL: localhost:8080/ingredients
public class IngredientsController {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    // Responds to GET requests at '/ingredients'
    @GetMapping
    public String displayIngredients(@RequestParam(required = false) Integer recipeId, Model model) {
        if (recipeId != null) {
            Optional<Recipe> result = recipeRepository.findById(recipeId);
            Recipe recipe = result.get();
            model.addAttribute("title", recipe.getName());
            return "ingredients/index";
        }

        model.addAttribute("title", "Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }

    // Responds to GET requests at '/ingredients/create'
    @GetMapping("create")
    public String renderIngredientForm(Model model) {
        model.addAttribute("title", "Create Ingredient");
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/create";
    }

    // Responds to POST requests at '/ingredients/create'
    @PostMapping("create")
    public String processIngredientForm(@ModelAttribute @Valid Ingredient newIngredient, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Ingredient");
            return "ingredients/create";
        }

        ingredientRepository.save(newIngredient);

        return "redirect:";
    }

    // Responds to GET requests at '/ingredients/create'
    @GetMapping("delete")
    public String renderDeleteForm(Model model) {
        model.addAttribute("title", "Delete Ingredient");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/delete";
    }

    // Responds to POST requests at '/ingredients/delete'
    @PostMapping("delete")
    public String processDeleteForm(@RequestParam(required = false) int[] ingredientIds) {
        if (ingredientIds != null) {
            for (int id : ingredientIds) {
                ingredientRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    // Responds to GET requests at '/ingredients/add'
    @GetMapping("add")
    public String renderAddForm(Model model) {
        model.addAttribute("title", "Select Recipe to Add Ingredient");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "ingredients/add";
    }
    
    // Responds to POST requests at '/ingredients/add'
    @PostMapping("add")
    public String processAddForm(@RequestParam int recipeId, Model model) {
        // Valid if user did NOT select a recipe to add an ingredient
        if (recipeId == 0) {
            model.addAttribute("title", "Invalid Selection");
            model.addAttribute("recipes", recipeRepository.findAll());
            return "ingredients/add";
        }
        
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        Recipe recipe = result.get();
    
        model.addAttribute("title", recipe.getName());
        return "redirect:add/" + recipe.getId() + "/" + recipe.getName();
    }


    // TODO:
    /*
     * You created a repository just for ingredients.
     * You could refactor the ingredient repository to:
     * 
     * ID | Ingredient | Category
     * --------------------------
     * x  | Sage       | Spice
     * y  | Milk       | Dairy
     * 
     * When you create a recipe, you can then add an extra input
     * field that allows the user to select ingredients on the same 
     * Create Recipe Page. That will allow the user to add a new recipe to the 
     * recipe repository with ID, Name, Cuisine, Category, and List of Ingredients.
     */


    // Responds to GET requests at '/ingredients/add/{recipeId}/{recipeName}'
    @GetMapping("add/{recipeId}/{recipeName}")
    public String renderAddIngredientToRecipeForm(@PathVariable int recipeId, @PathVariable String recipeName, Model model) {
        model.addAttribute("title", "Add Ingredients: " + recipeName);
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/select";
    }

    // Responds to POST requests at '/ingrdients/add/{recipeId}/{recipeName}'
    @PostMapping("add/{recipeId}/{recipeName}")
    public String processAddIngredientToRecipeForm(@ModelAttribute Ingredient newIngredient, @PathVariable int recipeId, @PathVariable String recipeName, Model model) {
        model.addAttribute("title", "Saved Ingredient to " + recipeName);
        ingredientRepository.save(newIngredient);
        return "recipes/index";
    }

}