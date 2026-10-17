package com.backend.task_tracker.DTO;

import java.util.List;

public record ResponseTasks(
        List<Task> tasks
) {
}
