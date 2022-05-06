package com.thechefsnotebook.thechefsnotebook.controllers;

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
    public String displayAllRecipes() {
        return "recipe";
    }
    
    // Lives at "/recipe"
    @PostMapping
    public String createRecipe( @RequestParam String name, 
                                @RequestParam String description,
                                Model model) {

        model.addAttribute("name", name);
        model.addAttribute("description", description);
        return "redirect:"; // redirect to "/recipe"

    }
}
