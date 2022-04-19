package com.thechefsnotebook.thechefsnotebook.controller;

import com.thechefsnotebook.thechefsnotebook.model.User;
import com.thechefsnotebook.thechefsnotebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/* Handles HTTP requests to the application */

@Controller // This means that this class is the Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after application path)
public class MainController {

    // This means to get the bean called userRepository which is
    // auto-generated by Spring. We will use it to handle the data.
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name,
                                            @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name.
        // @RequestParam means it is the parameter from the GET or POST request.

        User someUser = new User();
        someUser.setName(name);
        someUser.setEmail(email);
        userRepository.save(someUser);
        return "Saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}
