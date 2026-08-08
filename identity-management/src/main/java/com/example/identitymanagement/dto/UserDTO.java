package com.example.identitymanagement.dto;

import com.example.sharedkernel.dto.BaseAuditEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseAuditEntityDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String mobileNumber;
    private Set<RoleDTO> roles;
}
