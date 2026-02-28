package com.app.smartsplit.service.impl;

import com.app.smartsplit.dto.UserRequest;
import com.app.smartsplit.dto.UserResponse;
import com.app.smartsplit.entity.User;
import com.app.smartsplit.exception.EmailAlreadyExistsException;
import com.app.smartsplit.repository.UserRepository;
import com.app.smartsplit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(UserRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email already exists");

        }
        User user= User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        User saved= userRepository.save(user);

        return UserResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .build();

    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream().map(u->UserResponse.builder().id(u.getId()).name(u.getName())
                .email(u.getEmail())
                .build()).toList();
    }
}
