package com.backend.task_tracker.controller;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.User;
import com.backend.task_tracker.service.TaskService;
import com.backend.task_tracker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
public class UserControllerImpl implements UserController {
    private final UserService userService;

    UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result  = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
