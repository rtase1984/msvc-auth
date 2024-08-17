package com.app.msvc_auth.infrastructure.controller;

import com.app.msvc_auth.application.dto.UserRegistrationDto;
import com.app.msvc_auth.application.usecase.RegisterUser;
import com.app.msvc_auth.domain.exception.UserNotFoundException;
import com.app.msvc_auth.domain.model.User;
import com.app.msvc_auth.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final RegisterUser registerUserUseCase;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto dto) {
        User user = registerUserUseCase.registerUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con id " + id));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRegistrationDto dto) {
        //User user = userRepository.updateUser(id, dto);
        return ResponseEntity.ok(userRepository.findById(id)
               .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con id " + id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // Lógica para eliminar un usuario
        return ResponseEntity.noContent().build();
    }
}
