package com.backend.task_tracker.controller;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.Task;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api")
public interface TaskController {
    @GetMapping("/tasks")
    public ResponseEntity<ResponseTasks> tasks (@RequestParam(value = "id") UUID userID);

    @PostMapping("/tasks")
    public ResponseEntity<ResponseTasks> addTask(@RequestParam(value = "id") UUID userID, @RequestBody Task taskDeails);

//    @PatchMapping("/tasks")
//    public ResponseEntity<ResponseTasks> upsdateTask(@RequestParam(value = "id") UUID userID, @RequestBody Task taskDeails);
}
