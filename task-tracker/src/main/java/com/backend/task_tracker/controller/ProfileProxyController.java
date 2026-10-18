package com.backend.task_tracker.controller;

import com.backend.task_tracker.service.ProfileClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discovery/profiles")
public class ProfileProxyController {

    private final ProfileClient profileClient;

    public ProfileProxyController(ProfileClient profileClient) {
        this.profileClient = profileClient;
    }

    @GetMapping("/{id}")
    public ProfileClient.ProfileResponse getProfile(@PathVariable Long id) {
        return profileClient.getProfile(id);
    }
}