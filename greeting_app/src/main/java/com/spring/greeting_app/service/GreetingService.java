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

    // uc2 - Returns a default greeting message
    public String getGreetingMessage() {
        return "Hello from the Service Layer!";
    }

    // uc3 - Returns a personalized greeting message
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName == null && lastName == null) {
            return "Hello!";
        }
        return "Hello, " + (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "") + "!";
    }

    // uc4 - Saves a new greeting message
    public GreetingMessage saveGreeting(String message) {
        GreetingMessage greeting = new GreetingMessage();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    // uc5 - Retrieves a greeting message by ID
    public Optional<GreetingMessage> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // uc6 - Retrieves all greeting messages
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // uc7 - Updates an existing greeting message by ID
    public Optional<GreetingMessage> updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(existingGreeting -> {
            existingGreeting.setMessage(newMessage);
            return greetingRepository.save(existingGreeting);
        });
    }
}
