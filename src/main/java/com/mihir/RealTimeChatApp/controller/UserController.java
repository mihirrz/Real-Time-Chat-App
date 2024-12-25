package com.mihir.RealTimeChatApp.controller;

import com.mihir.RealTimeChatApp.dto.UserDTO;
import com.mihir.RealTimeChatApp.model.UserModel;
import com.mihir.RealTimeChatApp.response.ApiResponse;
import com.mihir.RealTimeChatApp.response.ErrorDetails;
import com.mihir.RealTimeChatApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registerUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorDetails> errorDetailsList = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> new ErrorDetails(fieldError.getField(), fieldError.getDefaultMessage()))
                    .toList();
            return ResponseEntity.badRequest().body(ApiResponse.failure("Validation failed", errorDetailsList));
        }

        try {
            userService.registerUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("User created successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.failure(e.getMessage()));
        }
    }

    // Authenticate user (login)
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?>> loginUser(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok(ApiResponse.success("Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.failure("Invalid username or password"));
        }
    }

    // Get user details by username
    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<?>> getUserByUsername(@PathVariable String username) {
        UserModel user = userService.getUserByUserName(username);
        if (user != null) {
            return ResponseEntity.ok(ApiResponse.success("User found", user));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.failure("User not found"));
    }

    // Update user details by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            UserModel updatedUser = userService.updateUser(id, userDTO);
            return ResponseEntity.ok(ApiResponse.success("User updated successfully", updatedUser));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.failure("User not found", e.getMessage()));
        }
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ApiResponse.success("User deleted successfully"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.failure("User not found", e.getMessage()));
        }
    }
}
