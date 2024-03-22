package com.focp2.controller;

import com.focp2.model.User;
import com.focp2.service.AuthService;

public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    public User login(String email, String password) {
        return authService.login(email, password);
    }
}
