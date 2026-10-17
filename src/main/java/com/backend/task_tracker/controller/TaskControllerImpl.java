package com.backend.task_tracker.controller;

import com.backend.task_tracker.DTO.ResponseTasks;
import com.backend.task_tracker.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TaskControllerImpl implements TaskController {
    private final TaskService taskService;

    TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }
    @Override
    public ResponseEntity<ResponseTasks> Tasks () {
        UUID userID = null;

        ResponseTasks result = taskService.getTasksDetails(userID);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
