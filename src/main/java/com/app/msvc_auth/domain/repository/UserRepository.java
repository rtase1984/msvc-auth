package com.app.msvc_auth.domain.repository;

import com.app.msvc_auth.domain.exception.UserNotFoundException;
import com.app.msvc_auth.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
