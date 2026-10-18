package com.backend.task_tracker.controller;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api")
public interface UserController {
    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody User ç);
}
