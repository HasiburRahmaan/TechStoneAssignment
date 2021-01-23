package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TemplateController {

    @GetMapping("/hello")
    public String homePage(Model model){
        return "index";
    }
}
