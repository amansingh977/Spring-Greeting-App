package com.spring.greeting_app.controller;

import com.spring.greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

// Marks this class as a REST Controller that returns JSON responses
@RestController
@RequestMapping("/greet")
public class GreetingController {

    // Injecting GreetingService
    private final GreetingService greetingService;

    // Constructor-based dependency injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // uc1 - Handles HTTP GET request and returns a greeting message as JSON
    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello, welcome to our Spring Boot app!");
    }

    // uc1 - Handles HTTP POST request and returns a creation message as JSON
    @PostMapping
    public Map<String, String> postGreeting() {
        return Map.of("message", "Greeting has been created!");
    }

    // uc1 - Handles HTTP PUT request and returns an update message as JSON
    @PutMapping
    public Map<String, String> putGreeting() {
        return Map.of("message", "Greeting has been updated!");
    }

    // uc1 - Handles HTTP DELETE request and returns a deletion message as JSON
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return Map.of("message", "Greeting has been deleted!");
    }

    // uc2 - Handles HTTP GET request and returns greeting from the Service Layer
    @GetMapping("/service")
    public Map<String, String> getServiceGreeting() {
        return Map.of("message", greetingService.getGreetingMessage());
    }

    // uc3 - Handles HTTP GET request to return a personalized greeting
    @GetMapping("/personalized")
    public Map<String, String> getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return Map.of("message", greetingService.getPersonalizedGreeting(firstName, lastName));
    }
}
