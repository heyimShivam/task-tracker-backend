package com.backend.task_tracker.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ProfileClient {

    private final RestClient restClient;

    public ProfileClient(@LoadBalanced RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://profile-service")
                .build();
    }

    public ProfileResponse getProfile(Long id) {
        return restClient.get()
                .uri("/api/profiles/{id}", id)
                .retrieve()
                .body(ProfileResponse.class);
    }

    public record ProfileResponse(Long id, String name) {}
}

