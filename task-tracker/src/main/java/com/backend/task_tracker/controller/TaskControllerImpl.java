package com.backend.task_tracker.controller;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.SuccessResponse;
import com.backend.task_tracker.dto.Task;
import com.backend.task_tracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TaskControllerImpl implements TaskController {
    private final TaskService taskService;

    TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<ResponseTasks> tasks (@PathVariable UUID userID) {
        ResponseTasks result = taskService.getTasksDetails(userID);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<ResponseTasks> addTask(@PathVariable UUID userID, @RequestBody Task taskDeails) {
        ResponseTasks result = taskService.addTasks(userID, taskDeails);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    public ResponseEntity<ResponseTasks> upsdateTask(@RequestParam(value = "id") UUID taskID, @RequestBody Task taskDeails) {
        ResponseTasks result = taskService.patchTask(taskID, taskDeails);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<SuccessResponse> deleteTask(@RequestParam(value = "id") UUID taskID) {
        taskService.deleteTask(taskID);

        SuccessResponse result = new SuccessResponse("Task deleted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
