package com.mihir.RealTimeChatApp.repository;

import com.mihir.RealTimeChatApp.model.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {
    List<ChatMessageModel> findBySenderIdAndRecipientId(Long senderId, Long recipientId);
}
