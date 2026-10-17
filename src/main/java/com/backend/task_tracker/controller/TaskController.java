package com.backend.task_tracker.controller;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TaskController {
    @GetMapping("/tasks/{userID}")
    public ResponseEntity<ResponseTasks> Tasks (@PathVariable UUID userID);

    @PostMapping("/tasks/{userID}")
    public ResponseEntity<ResponseTasks> addTask(@PathVariable UUID userID, @RequestBody Task taskDeails);

    @GetMapping("/get-uuid")
    public UUID getUUID();
}
