package com.backend.task_tracker.service;

import com.backend.task_tracker.dto.ResponseTasks;
import com.backend.task_tracker.dto.Task;

import java.util.UUID;

public interface TaskService {
    public ResponseTasks getTasksDetails(UUID userID);
    public ResponseTasks addTasks(UUID userID, Task taskDeails);
}
