package com.backend.task_tracker.service;

import com.backend.task_tracker.dto.User;
import com.backend.task_tracker.entity.UserEntity;
import com.backend.task_tracker.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional()
    public User createUser(User request) {
        UserEntity entity = new UserEntity(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password())
        );

        UserEntity saved = userRepository.save(entity);

        return new User(
                saved.getUserId(),
                saved.getName(),
                saved.getEmail(),
                null
        );
    }
}
