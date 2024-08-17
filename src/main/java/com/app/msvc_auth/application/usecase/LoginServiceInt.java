package com.app.msvc_auth.application.usecase;

import com.app.msvc_auth.application.dto.AuthResponseDto;
import com.app.msvc_auth.application.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface LoginServiceInt {
    AuthResponseDto authenticate(LoginRequest loginRequest);
}
