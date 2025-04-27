package com.epf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CoursEpfBack")
public class HomeController {
    @GetMapping("/CoursEpfBack")
    public String home() {
        return "Bienvenue sur l'API CoursEpfBack !";
    }
}
