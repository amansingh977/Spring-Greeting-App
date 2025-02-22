package com.spring.greeting_app.service;

import com.spring.greeting_app.model.GreetingMessage;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Service Layer for handling Greeting logic
@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // uc2 - Returns a simple greeting message
    public String getGreetingMessage() {
        return "Hello from the Service Layer!";
    }

    // uc3 - Returns a personalized greeting message
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello, Guest!";
        }
        if (firstName == null) {
            return "Hello, " + lastName + "!";
        }
        if (lastName == null) {
            return "Hello, " + firstName + "!";
        }
        return "Hello, " + firstName + " " + lastName + "!";
    }

    // uc4 - Saves a greeting message to the repository
    public GreetingMessage saveGreeting(String message) {
        return greetingRepository.save(new GreetingMessage(message));
    }

    // uc4 - Retrieves a greeting message by ID
    public Optional<GreetingMessage> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // uc5 - Finds a Greeting Message by ID in the Repository
    public Optional<GreetingMessage> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
