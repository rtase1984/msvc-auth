package com.app.msvc_auth.application.usecase;

import com.app.msvc_auth.application.dto.UserRegistrationDto;
import com.app.msvc_auth.domain.model.User;
import com.app.msvc_auth.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setActive(true);
        user.setRoles(dto.getRoles());

        return userRepository.save(user);
    }
}
