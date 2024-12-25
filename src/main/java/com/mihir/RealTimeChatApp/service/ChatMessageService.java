package com.mihir.RealTimeChatApp.service;

import com.mihir.RealTimeChatApp.model.ChatMessageModel;
import com.mihir.RealTimeChatApp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageModel saveMessage(ChatMessageModel message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessageModel> getAllMessages() {
        return chatMessageRepository.findAll();
    }

    public void deleteMessage(Long id) {
        chatMessageRepository.deleteById(id);
    }
}
