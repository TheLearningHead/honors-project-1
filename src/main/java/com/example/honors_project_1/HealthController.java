package com.example.honors_project_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String root() {
        return "Airline Management System is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
