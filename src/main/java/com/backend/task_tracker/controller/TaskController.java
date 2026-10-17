package com.backend.task_tracker.controller;

import com.backend.task_tracker.DTO.ResponseTasks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface TaskController {
    @GetMapping("/tasks")
    public ResponseEntity<ResponseTasks> Tasks ();
}
