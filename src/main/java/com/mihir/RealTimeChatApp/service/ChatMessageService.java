package com.mihir.RealTimeChatApp.service;

import com.mihir.RealTimeChatApp.dto.ChatMessageDTO;
import com.mihir.RealTimeChatApp.model.ChatMessageModel;
import com.mihir.RealTimeChatApp.model.UserModel;
import com.mihir.RealTimeChatApp.repository.ChatMessageRepository;
import com.mihir.RealTimeChatApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    // Save a chat message
    public ChatMessageModel saveMessage(ChatMessageDTO chatMessageDTO) {
        Optional<UserModel> sender = userRepository.findById(chatMessageDTO.getSenderId());
        Optional<UserModel> recipient = userRepository.findById(chatMessageDTO.getRecipientId());

        if (sender.isEmpty() || recipient.isEmpty()) {
            throw new IllegalArgumentException("Sender or recipient not found");
        }

        ChatMessageModel chatMessageModel = new ChatMessageModel();
        chatMessageModel.setSenderId(sender.get().getId());
        chatMessageModel.setRecipientId(recipient.get().getId());
        chatMessageModel.setContent(chatMessageDTO.getContent());
        chatMessageModel.setType(chatMessageDTO.getType());


        return chatMessageRepository.save(chatMessageModel);
    }

    // Retrieve chat history for a specific user and recipient
    public List<ChatMessageModel> getChatHistory(String username, Long recipientId) {
        UserModel user = userRepository.findByUserName(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return chatMessageRepository.findBySenderIdAndRecipientId(user.getId(), recipientId);

    }
}
