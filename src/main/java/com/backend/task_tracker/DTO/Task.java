package com.backend.task_tracker.DTO;

public record Task(
        String name,
        String description,
        Boolean isCompleted
) {
}
