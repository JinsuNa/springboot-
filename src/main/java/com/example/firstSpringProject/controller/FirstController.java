package com.example.firstSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("userName", "나진수");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouLater(Model model) {
        model.addAttribute("userName", "나진수");
        return "bye";
    }
}
