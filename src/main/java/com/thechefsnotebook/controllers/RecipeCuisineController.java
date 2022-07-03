package com.thechefsnotebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thechefsnotebook.data.RecipeCuisineRepository;

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
        return "cuisines/index";
    }
    
    // Respondes to GET requests at URL "/recipes/cuisine/create"
    // Respondes to POST requests at URL "/recipes/cuisine/create"
    // Respondes to GET requests at URL "/recipes/cuisine/delete"
    // Respondes to POST requests at URL "/recipes/cuisine/delete"
    
}
