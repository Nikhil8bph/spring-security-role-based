package com.example.identitymanagement.facade;

import com.example.identitymanagement.mapper.UserMapper;
import com.example.identitymanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    //TODO create user

    //TODO update user

    //TODO restore user

    //TODO delete user

    //TODO get user

    //TODO get user paged with filters
}
