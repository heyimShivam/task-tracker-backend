package com.backend.task_tracker.Service;

import com.backend.task_tracker.DTO.ResponseTasks;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface TaskService {
    public ResponseTasks getTasksDetails(UUID userID);
}
