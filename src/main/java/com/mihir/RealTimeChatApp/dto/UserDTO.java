package com.mihir.RealTimeChatApp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@NoArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phoneNo;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    public UserDTO(Long id, String userName, String name, String email, String phoneNo, String password) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
