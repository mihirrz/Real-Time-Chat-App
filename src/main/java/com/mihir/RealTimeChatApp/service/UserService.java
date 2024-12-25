package com.mihir.RealTimeChatApp.service;

import com.mihir.RealTimeChatApp.dto.UserDTO;
import com.mihir.RealTimeChatApp.model.UserModel;
import com.mihir.RealTimeChatApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to register a new user
    public UserModel registerUser(UserDTO userDTO) {
        // Check if username or email already exists
        if (userRepository.existsByUserName(userDTO.getUserName()) ||
                userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("Username or Email already exists.");
        }

        // Encode the user's password before saving it
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

        // Convert UserDTO to UserModel
        UserModel user = new UserModel();
        user.setUserName(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNo(userDTO.getPhoneNo());
        user.setPassword(encodedPassword);

        // Save and return the user
        return userRepository.save(user);
    }

    // Method to authenticate user (login)
    public boolean authenticateUser(String username, String rawPassword) {
        UserModel user = userRepository.findByUserName(username);
        if (user != null) {
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }

    // Method to get user by username (if needed for other operations)
    public UserModel getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    // Method to get a user by ID
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    // Method to update user details
    public UserModel updateUser(Long id, UserDTO userDTO) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Update user details
        user.setUserName(userDTO.getUserName());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNo(userDTO.getPhoneNo());

        // Save and return updated user
        return userRepository.save(user);
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
