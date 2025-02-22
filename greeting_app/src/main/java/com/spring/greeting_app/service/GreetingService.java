package com.spring.greeting_app.service;

import org.springframework.stereotype.Service;

// Marks this class as a Spring Service component
@Service
public class GreetingService {

    // uc2 - Returns a simple greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }
}

