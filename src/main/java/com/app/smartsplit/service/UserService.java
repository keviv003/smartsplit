package com.app.smartsplit.service;

import com.app.smartsplit.dto.UserRequest;
import com.app.smartsplit.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse register(UserRequest request);
    List<UserResponse> getAllUsers();

}
