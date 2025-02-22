package com.spring.greeting_app.repository;

import com.spring.greeting_app.model.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// uc4 - Repository for managing GreetingMessage entities
@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessage, Long> {
}
