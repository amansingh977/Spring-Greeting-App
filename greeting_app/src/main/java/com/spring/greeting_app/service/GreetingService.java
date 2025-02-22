package com.spring.greeting_app.service;

import org.springframework.stereotype.Service;

// Marks this class as a Spring Service component
@Service
public class GreetingService {

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
}

