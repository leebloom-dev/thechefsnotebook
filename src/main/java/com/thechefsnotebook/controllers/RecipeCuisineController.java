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

import com.thechefsnotebook.data.RecipeCuisineRepository;
import com.thechefsnotebook.models.RecipeCuisine;

@Controller
@RequestMapping("recipes/cuisine")
public class RecipeCuisineController {

    @Autowired
    private RecipeCuisineRepository recipeCuisineRepository;

    // Responds to GET requests at URL "/recipes/cuisine"
    @GetMapping
    public String displayCuisines(Model model) {
        model.addAttribute("title", "Cuisines");
        model.addAttribute("recipeCuisines", recipeCuisineRepository.findAll());
        model.addAttribute("isCategory", false);
        model.addAttribute("isCuisine", true);
        return "cuisine/index";
    }
    
    // Respondes to GET requests at URL "/recipes/cuisine/create"
    @GetMapping("create")
    public String renderCuisineForm(Model model) {
        model.addAttribute("title", "Cuisine Form");
        model.addAttribute("recipeCuisine", new RecipeCuisine());
        return "cuisine/create";
    }

    // Respondes to POST requests at URL "/recipes/cuisine/create"
    @PostMapping("create")
    public String processCuisineForm(@ModelAttribute @Valid RecipeCuisine newRecipeCuisine,
                                        Errors errors, Model model) {
        
        if (errors.hasErrors()) {
            model.addAttribute("title", "Cuisine Form");
            return "cuisine/create";
        }

        recipeCuisineRepository.save(newRecipeCuisine);
        return "redirect:";
    }

    // Respondes to GET requests at URL "/recipes/cuisine/delete"
    @GetMapping("delete")
    public String renderDeleteForm(Model model) {
        model.addAttribute("title", "Delete Cuisine");
        model.addAttribute("recipeCuisines", recipeCuisineRepository.findAll());
        return "cuisine/delete";
    }

    // Respondes to POST requests at URL "/recipes/cuisine/delete"
    @PostMapping("delete")
    public String processDeleteForm(@RequestParam(required = false) int[] recipeCuisineIds) {
        // If the array of cuisine ids is NOT null, delete from repository
        if (recipeCuisineIds != null) {
            for (int recipeCuisineId : recipeCuisineIds) {
                recipeCuisineRepository.deleteById(recipeCuisineId);
            }
        }

        return "redirect:";
    }
    
}
