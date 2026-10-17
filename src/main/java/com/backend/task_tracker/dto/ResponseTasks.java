package com.backend.task_tracker.dto;

import java.util.List;

public record ResponseTasks(
        List<Task> tasks
) {
}
