package com.thechefsnotebook.controllers;

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

import com.thechefsnotebook.data.IngredientRepository;
import com.thechefsnotebook.data.RecipeRepository;
import com.thechefsnotebook.models.Ingredient;
import com.thechefsnotebook.models.Recipe;
import com.thechefsnotebook.models.dto.RecipeIngredientDTO;

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
    public String processIngredientForm(@ModelAttribute @Valid Ingredient newIngredient, 
                                        Errors errors, Model model) {
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

    // Responds to GET requests at '/ingredients/select-recipe'
    @GetMapping("select-recipe")
    public String renderAddForm(Model model) {
        model.addAttribute("title", "Select Recipe to Add Ingredient");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "ingredients/select-recipe";
    }
    
    // Responds to GET requests at '/ingredients/add-ingredient'
    @GetMapping("add-ingredient")
    public String renderAddIngredient(@RequestParam int recipeId, Model model) {

        // Validate if user did NOT select a recipe to add an ingredient
        if (recipeId == 0) {
            model.addAttribute("title", "Invalid Selection");
            model.addAttribute("recipes", recipeRepository.findAll());
            return "ingredients/select-recipe";
        }

        // Get recipe from repository using ID to display title
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        Recipe recipe = result.get();
        model.addAttribute("title", "Add Ingredient To: " + recipe.getName());

        // Add ingredients to the model
        model.addAttribute("ingredients", ingredientRepository.findAll());

        // Set recipe object to the recipe-ingredient-dto
        RecipeIngredientDTO recipeIngredient = new RecipeIngredientDTO();
        recipeIngredient.setRecipe(recipe);

        // Add recipe-ingredient-dto object to the model
        model.addAttribute("recipeIngredient", recipeIngredient);
        
        return "ingredients/add-ingredient";
    }

    // Responds to POST requests at '/ingredients/add-ingredient'
    @PostMapping("add-ingredient")
    public String processAddIngredient(@ModelAttribute @Valid RecipeIngredientDTO recipeIngredient,
                                       Errors errors,
                                       Model model) {

        // If no errors
        if (!errors.hasErrors()) {
            Recipe recipe = recipeIngredient.getRecipe();
            Ingredient ingredient = recipeIngredient.getIngredient();

            // If the recipe does NOT contain this ingredient:
            // Add ingredient to recipe object and save to recipe repository.
            if(!recipe.getIngredients().contains(ingredient)) {
                recipe.addIngredient(ingredient);
                recipeRepository.save(recipe);
            }
            return "redirect:add-ingredient?recipeId=" + recipe.getId();
        }

        // If errors exist redirect back to the add-ingredient page
        return "redirect:add-ingredient";

    }

}