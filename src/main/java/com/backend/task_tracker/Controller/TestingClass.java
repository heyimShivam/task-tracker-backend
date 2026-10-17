package com.backend.task_tracker.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestingClass {
    @GetMapping("/health")
    public ResponseEntity<Object> applicationHealth() {
        return ResponseEntity.ok(Map.of("status", "UP"));
    }
}
