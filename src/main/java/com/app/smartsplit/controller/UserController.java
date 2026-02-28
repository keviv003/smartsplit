package com.app.smartsplit.controller;


import com.app.smartsplit.dto.UserRequest;
import com.app.smartsplit.dto.UserResponse;
import com.app.smartsplit.exception.MissingMandatoryException;
import com.app.smartsplit.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return ResponseEntity.ok(service.getAllUsers());
    }


}
