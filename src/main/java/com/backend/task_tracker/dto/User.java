package com.backend.task_tracker.dto;

import java.util.UUID;

public record User(
        UUID userId,
        String name,
        String email,
        String password
) {}
