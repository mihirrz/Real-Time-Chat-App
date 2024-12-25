package com.mihir.RealTimeChatApp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.awt.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Sender cannot be blank")
    private String sender;

    @Column(nullable = false)
    @NotBlank(message = "Content cannot be blank")
    private String content;

    @Enumerated(EnumType.STRING)
    private TrayIcon.MessageType type;

    private Long timestamp; // You can use System.currentTimeMillis() to set this value
}

