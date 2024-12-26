package com.mihir.RealTimeChatApp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;


@Data
public class ChatMessageDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long senderId;

    private Long recipientId; // Null for group messages

    @Column(nullable = false)
    @NotBlank(message = "Content cannot be blank")
    private String content;

    @Enumerated(EnumType.STRING)
    private TrayIcon.MessageType type;

    private LocalDateTime timestamp;

    public ChatMessageDTO(Long id, Long senderId, Long recipientId, String content, TrayIcon.MessageType type, LocalDateTime timestamp) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.content = content;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TrayIcon.MessageType getType() {
        return type;
    }

    public void setType(TrayIcon.MessageType type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}