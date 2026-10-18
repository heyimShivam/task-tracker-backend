package com.backend.task_tracker.service;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.Task;
import com.backend.task_tracker.entity.TaskEntity;
import com.backend.task_tracker.entity.UserEntity;
import com.backend.task_tracker.repository.TaskRepository;
import com.backend.task_tracker.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public ResponseTasks getTasksDetails(UUID userID) {
        if (!userRepository.existsById(userID)) {
            throw new IllegalArgumentException("User not found: " + userID);
        }

        List<Task> tasks = taskRepository.findByUser_UserId(userID)
                .stream()
                .map(task -> new Task(
                        task.getTaskId(),
                        task.getName(),
                        task.getDescription(),
                        task.getIsCompleted()
                ))
                .toList();

        return new ResponseTasks(tasks);
    }

    @Transactional
    public ResponseTasks addTasks(UUID userID, Task taskDetails) {
        UserEntity user = userRepository.findById(userID)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "User not found: " + userID));

        TaskEntity entity = new TaskEntity(
                taskDetails.name(),
                taskDetails.description(),
                taskDetails.isCompleted(),
                user
        );

        TaskEntity saved = taskRepository.save(entity);

        Task responseTask = new Task(
                saved.getTaskId(),
                saved.getName(),
                saved.getDescription(),
                saved.getIsCompleted()
        );

        return new ResponseTasks(List.of(responseTask));
    }

    @Transactional
    public ResponseTasks patchTask(UUID taskID, Task taskDeails) {
        TaskEntity task = taskRepository.findById(taskID)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Task not found: " + taskID));

        task.setName(taskDeails.name());
        task.setDescription(taskDeails.description());
        task.setIsCompleted(taskDeails.isCompleted());

        Task responseTask = new Task(
                task.getTaskId(),
                task.getName(),
                task.getDescription(),
                task.getIsCompleted()
        );

        return new ResponseTasks(List.of(responseTask));
    }

    @Transactional
    public void deleteTask(UUID taskID) {
        TaskEntity task = taskRepository.findById(taskID)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Task not found: " + taskID));

        taskRepository.delete(task);
    }
}
