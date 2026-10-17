package com.backend.task_tracker.dto;

import java.util.UUID;

public record Task(
        UUID taskID,
        String name,
        String description,
        Boolean isCompleted
) {
    public Task {
        if (taskID == null) {
            taskID = UUID.randomUUID();
        }
    }

    public Task(String name, String description, Boolean isCompleted) {
        this(UUID.randomUUID(), name, description, isCompleted);
    }
}
