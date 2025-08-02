package com.example.springcrudapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name = "Application", description = "Application health and status APIs")
@CrossOrigin(origins = "*")
public class AppController {
    
    @GetMapping("/")
    @Operation(summary = "Root endpoint", description = "Returns a welcome message")
    @ApiResponse(responseCode = "200", description = "Welcome message")
    public String getHello() {
        return "Spring Boot CRUD API is running!";
    }
    
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Returns the application health status")
    @ApiResponse(responseCode = "200", description = "Health status")
    public Map<String, Object> getHealth() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "ok");
        health.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        health.put("service", "Spring Boot CRUD API");
        health.put("version", "1.0.0");
        return health;
    }
} 