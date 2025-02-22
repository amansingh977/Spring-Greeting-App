package com.spring.greeting_app.service;

import com.spring.greeting_app.model.GreetingMessage;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service Layer for Greeting App
@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // uc2 - Returns a simple greeting message
    public String getGreetingMessage() {
        return "Hello from the Greeting Service!";
    }

    // uc3 - Returns a personalized greeting message
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello, Guest!";
        }
        return "Hello, " + (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }

    // uc4 - Saves a new greeting message
    public GreetingMessage saveGreeting(String message) {
        return greetingRepository.save(new GreetingMessage(message));
    }

    // uc5 - Retrieves a greeting message by ID
    public Optional<GreetingMessage> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // uc6 - Retrieves all greeting messages
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // uc7 - Updates an existing greeting message
    public GreetingMessage updateGreeting(Long id, String message) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(message);
                    return greetingRepository.save(greeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting not found"));
    }

    // uc8 - Deletes a greeting message by ID
    public String deleteGreetingById(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return "Greeting message deleted successfully.";
        }
        return "Greeting message not found.";
    }
}
