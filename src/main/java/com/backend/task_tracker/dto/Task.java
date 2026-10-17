package com.backend.task_tracker.dto;

import java.util.UUID;

public record Task(
        UUID taskID,
        String name,
        String description,
        Boolean isCompleted
) {}
