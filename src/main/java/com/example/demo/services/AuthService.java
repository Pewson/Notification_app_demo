package com.example.demo.services;

import com.example.demo.repositories.UserCredsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    private final UserCredsRepository userCredsRepository;
    @Autowired
    public AuthService(UserCredsRepository userCredsRepository) {
        this.userCredsRepository = userCredsRepository;
    }

    public UUID getLoggedInClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getName() != null) {
            String username = authentication.getName();
            UUID userCredId = userCredsRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalStateException("User not found: " + username))
                    .getId();
            return userCredsRepository.findClientIdByUCId(userCredId)
                    .orElseThrow(() -> new IllegalStateException("Client ID not found for user: " + username));
        }
        throw new IllegalStateException("No authenticated client found");
    }
}