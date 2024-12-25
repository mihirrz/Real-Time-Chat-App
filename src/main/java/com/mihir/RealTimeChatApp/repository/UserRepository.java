package com.mihir.RealTimeChatApp.repository;

import com.mihir.RealTimeChatApp.model.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean existsByUserName(@NotBlank(message = "Username is required") String userName);

    boolean existsByEmail(@Email(message = "Invalid email format") String email);

    UserModel findByUserName(String username);
}
