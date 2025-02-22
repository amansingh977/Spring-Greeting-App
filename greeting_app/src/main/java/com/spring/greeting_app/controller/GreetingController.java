package com.spring.greeting_app.controller;

import com.spring.greeting_app.model.GreetingMessage;
import com.spring.greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// uc1 - REST Controller for Greeting App
@RestController
@RequestMapping("/greet")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // uc1 - Handles HTTP GET request and returns a greeting message as JSON
    @GetMapping
    public Map<String, String> getGreeting() {
        return Map.of("message", "Hello, welcome to our Spring Boot app!");
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

    // uc4 - Handles HTTP POST request to save a greeting message
    @PostMapping("/save")
    public GreetingMessage saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }

    // uc5 - Handles HTTP GET request to retrieve a greeting message by ID
    @GetMapping("/get/{id}")
    public Optional<GreetingMessage> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // uc6 - Handles HTTP GET request to retrieve all greeting messages
    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
