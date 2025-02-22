package com.spring.greeting_app.service;

import com.spring.greeting_app.model.GreetingMessage;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// uc2 - Service class for greeting messages
@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // uc2 - Returns a default greeting message
    public String getGreetingMessage() {
        return "Hello, welcome to our Spring Boot app!";
    }

    // uc3 - Returns a personalized greeting message
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello, Guest!";
        }
        return "Hello, " + (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "") + "!";
    }

    // uc4 - Saves a greeting message in the repository
    public GreetingMessage saveGreeting(String message) {
        return greetingRepository.save(new GreetingMessage(message));
    }

    // uc5 - Retrieves a greeting message by ID
    public Optional<GreetingMessage> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // uc6 - Retrieves all greeting messages from the repository
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
