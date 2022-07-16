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

import com.thechefsnotebook.data.IngredientRepository;
import com.thechefsnotebook.models.Ingredient;

@Controller
@RequestMapping("ingredients") // URL: localhost:8080/ingredients
public class IngredientsController {

    @Autowired
    IngredientRepository ingredientRepository;

    // Responds to GET requests at '/ingredients'
    @GetMapping
    public String displayIngredients(Model model) {
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

}