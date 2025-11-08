package com.test.authtest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public ResponseEntity<String> test() {
        logger.info("Test endpoint accessed");
        return ResponseEntity.ok("Narasimha is greatest of all time :)");
    }

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        logger.info("Check endpoint accessed");
        return ResponseEntity.ok("Test endpoint is working!");
    }
}
