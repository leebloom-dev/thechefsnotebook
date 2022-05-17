package com.thechefsnotebook.thechefsnotebook.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("events")
public class EventsController {

    private List<String> events = new ArrayList<>();
    
    // responds to GET requests at "/events"
    @GetMapping
    public String renderEvents(Model model) {
        model.addAttribute("events", events);
        return "events/events";
    }

    // responds to POST requests at /events
    @PostMapping
    public String processEventForm(@RequestParam String event) {
        events.add(event);
        return "redirect:/events";
    }

}
