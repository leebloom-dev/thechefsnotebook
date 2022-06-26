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
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
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

    // Responds to GET requests at "/recipes/category/delete"
    @GetMapping("delete")
    public String displayDeleteCategoryForm(Model model) {
        model.addAttribute("title", "Delete Recipe Category");
        model.addAttribute("recipeCategories", recipeCategoryRepository.findAll());
        return "category/delete";
    }


    // Responds to POST requests at "/recipes/category/delete"
    @PostMapping("delete")
    public String processDeleteCategoryForm(@RequestParam(required = false) int[] recipeCategoryIds) {

        // If the selection is NOT empty
        if (recipeCategoryIds != null) {
            for (int recipeCategoryId : recipeCategoryIds) {
                recipeCategoryRepository.deleteById(recipeCategoryId);
            }
        }

        return "redirect:";
    }

}
