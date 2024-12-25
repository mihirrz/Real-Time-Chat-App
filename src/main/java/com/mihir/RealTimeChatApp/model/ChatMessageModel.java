package com.mihir.RealTimeChatApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String content;
    @Enumerated(EnumType.STRING)
    private TrayIcon.MessageType type;
    private Long timestamp;
}

