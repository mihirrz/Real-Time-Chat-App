package com.mihir.RealTimeChatApp.repository;

import com.mihir.RealTimeChatApp.model.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {
}
