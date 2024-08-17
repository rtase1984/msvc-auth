package com.app.msvc_auth.infrastructure.controller;

import com.app.msvc_auth.application.dto.AuthResponseDto;
import com.app.msvc_auth.application.dto.LoginRequest;
import com.app.msvc_auth.application.usecase.imp.LoginServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginServiceImp authService;

    @GetMapping(value = "login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
