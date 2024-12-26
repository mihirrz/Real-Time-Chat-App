package com.mihir.RealTimeChatApp.controller;

import com.mihir.RealTimeChatApp.dto.ChatMessageDTO;
import com.mihir.RealTimeChatApp.model.ChatMessageModel;
import com.mihir.RealTimeChatApp.response.ApiResponse;
import com.mihir.RealTimeChatApp.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages/{username}")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    // Endpoint to send a message
    @PostMapping("/send")
    public ResponseEntity<ApiResponse<?>> sendMessage(@RequestBody ChatMessageDTO chatMessageDTO) {
        try {
            ChatMessageModel savedMessage = chatMessageService.saveMessage(chatMessageDTO);
            return ResponseEntity.ok(ApiResponse.success("Message sent successfully", savedMessage));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ApiResponse.failure("Invalid input", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.failure("Error sending message", e.getMessage()));
        }
    }

    // Endpoint to fetch chat history for a specific user
    @GetMapping("/history")
    public ResponseEntity<ApiResponse<?>> getChatHistory(@PathVariable String username,
                                                         @RequestParam Long recipientId) {
        try {
            List<ChatMessageModel> chatHistory = chatMessageService.getChatHistory(username, recipientId);
            return ResponseEntity.ok(ApiResponse.success("Chat history retrieved successfully", chatHistory));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ApiResponse.failure("Invalid input", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ApiResponse.failure("Error retrieving chat history", e.getMessage()));
        }
    }
}

