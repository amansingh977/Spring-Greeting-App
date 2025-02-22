package com.spring.greeting_app.service;

import com.spring.greeting_app.model.GreetingMessage;
import com.spring.greeting_app.repository.GreetingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

// uc4 - Service layer to handle Greeting operations
@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // uc2 - Returns a simple greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }

    // uc3 - Returns a personalized greeting based on provided names
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World";
        }
    }

    // uc4 - Saves a greeting message to the database
    public GreetingMessage saveGreeting(String message) {
        GreetingMessage greetingMessage = new GreetingMessage(message);
        return greetingRepository.save(greetingMessage);
    }

    // uc4 - Retrieves a greeting message by ID
    public Optional<GreetingMessage> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
}
