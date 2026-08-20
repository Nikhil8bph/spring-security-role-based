package com.example.identitymanagement.facade;

import com.example.identitymanagement.dto.RoleDTO;
import com.example.identitymanagement.dto.UserDTO;
import com.example.identitymanagement.entity.Role;
import com.example.identitymanagement.entity.User;
import com.example.identitymanagement.mapper.UserMapper;
import com.example.identitymanagement.repository.RoleRepository;
import com.example.identitymanagement.repository.UserRepository;
import com.example.sharedkernel.exception.UserNotFoundException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public void userExists(String mobileNumber, String email) {
        findByMobileNumberOrEmail(mobileNumber, email);
    }

    public UserDTO findByMobileNumberOrEmail(@NotBlank String mobileNumber, @NotBlank @Email String email) {
        return userRepository.findByMobileNumberOrEmail(mobileNumber, email)
                .map(userMapper::toDTO)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));
    }

    public UserDTO createUser(UserDTO userDTO, String roleName) {
        Role role = roleRepository.findByName(roleName);
        User user = userMapper.toEntity(userDTO);
        user.getRoles().add(role);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    //TODO update user

    //TODO restore user

    //TODO delete user

    //TODO get user

    //TODO get user paged with filters
}
