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

import com.thechefsnotebook.data.RecipeCategoryRepository;
import com.thechefsnotebook.models.RecipeCategory;

@Controller
@RequestMapping("recipes/category") // URL "localhost:8080/recipes/category"
public class RecipeCategoryController {

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;
    
    // Responds to GET request at "/recipes/category"
    @GetMapping
    public String displayCategories(Model model) {
        model.addAttribute("title", "Recipe Category");
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "category/index";
    }
    
    // Responds to GET request at "/recipes/category/create"
    @GetMapping("create")
    public String displayCategoryForm(Model model) {
        model.addAttribute("title", "Create Recipe Category");
        model.addAttribute("recipeCategory", new RecipeCategory());
        return "category/create";
    }
    
    // Responds to POST request at "/recipes/category/create"
    @PostMapping("create")
    public String processCategoryForm(@ModelAttribute @Valid RecipeCategory newRecipeCategory,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Recipe Category");
            return "category/create";
        }

        recipeCategoryRepository.save(newRecipeCategory);
        return "redirect:";
    }

}
