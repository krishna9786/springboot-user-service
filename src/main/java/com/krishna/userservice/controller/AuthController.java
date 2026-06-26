package com.krishna.userservice.controller;

import com.krishna.userservice.dto.LoginRequest;
import com.krishna.userservice.dto.LoginResponse;
import com.krishna.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        return new LoginResponse(token);
    }
}