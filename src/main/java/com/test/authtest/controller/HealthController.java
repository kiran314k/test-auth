package com.test.authtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HealthController {
    private static final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @GetMapping(value = {"", "/"})
    public ResponseEntity<String> root() {
        logger.info("Root endpoint accessed");
        return ResponseEntity.ok("Welcome to the application!");
    }

    @GetMapping(value = {"/health", "/actuator/health", "/health/readiness", "/health/liveness"})
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check endpoint accessed");
        return ResponseEntity.ok("Application is running!");
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        logger.info("Ping endpoint accessed");
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/test-external")
    public ResponseEntity<Object> testExternal() {
        logger.info("External test endpoint accessed");
        return ResponseEntity.ok(Map.of(
            "status", "success",
            "timestamp", System.currentTimeMillis(),
            "message", "Successfully accessed from external network",
            "server", "Azure App Service"
        ));
    }
}
