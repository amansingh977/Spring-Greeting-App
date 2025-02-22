package com.spring.greeting_app.model;

import jakarta.persistence.*;

// uc4 - Entity representing a Greeting Message
@Entity
public class GreetingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    // Default constructor
    public GreetingMessage() {}

    // Constructor
    public GreetingMessage(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
