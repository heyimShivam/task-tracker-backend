package com.service.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @GetMapping("/{id}")
    public ProfileResponse getProfile(@PathVariable Long id) {
        return new ProfileResponse(id, "Asha");
    }

    public record ProfileResponse(Long id, String name) {}
}
