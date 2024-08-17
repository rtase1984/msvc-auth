package com.app.msvc_auth.infrastructure.adapter.persistence;

import com.app.msvc_auth.domain.exception.UserNotFoundException;
import com.app.msvc_auth.domain.model.User;
import com.app.msvc_auth.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPersistenceAdapter {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Actualiza los datos del usuario sin permitir la modificación del username ni la contraseña.
     *
     * @param id   El ID del usuario a actualizar.
     * @param user El objeto User que contiene los datos a actualizar.
     * @return El usuario actualizado.
     * @throws UserNotFoundException si el usuario no existe.
     */
    public User updateUser(Long id, User user) throws UserNotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        // Actualizar solo los campos permitidos
        existingUser.setEmail(user.getEmail());
        // Otros campos permitidos para la actualización
        // existingUser.setOtherField(user.getOtherField());

        return userRepository.save(existingUser);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
