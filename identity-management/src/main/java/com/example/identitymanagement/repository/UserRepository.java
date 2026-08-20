package com.example.identitymanagement.repository;

import com.example.identitymanagement.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByMobileNumberOrEmail(@NotBlank String mobileNumber, @NotBlank @Email String email);
}
