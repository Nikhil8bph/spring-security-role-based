package com.example.identitymanagement.entity;

import com.example.sharedkernel.entity.BaseAuditEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
                , @UniqueConstraint(columnNames = "email")
                , @UniqueConstraint(columnNames = "mobile_number")
        })
public class User extends BaseAuditEntity {

    private String firstName;

    private String lastName;

    @NotBlank
    private String username;

    private String password;

    @Email
    private String email;

    private String mobileNumber;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @OrderBy("name ASC")
    @Size(min = 1, max = 20, message = "User must have at least one role")
    private Set<Role> roles = new HashSet<>();
}
