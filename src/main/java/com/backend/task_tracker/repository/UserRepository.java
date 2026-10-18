package com.backend.task_tracker.repository;

import com.backend.task_tracker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID>  {
}
