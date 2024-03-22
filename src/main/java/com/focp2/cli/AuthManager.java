package com.focp2.cli;

import com.focp2.model.User;
import com.focp2.service.AuthService;

public class AuthManager {
    private final AuthService authService;

    public AuthManager(AuthService authService) {
        this.authService = authService;
    }

    public User login(String email, String password) {
        return authService.login(email, password);
    }

    public void logout() {
        authService.logout();
    }
}
