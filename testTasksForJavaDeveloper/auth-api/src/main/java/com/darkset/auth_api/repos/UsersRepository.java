package com.darkset.auth_api.repos;

import com.darkset.auth_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User , UUID> {
    Optional<User> findByEmail(String email);
}
