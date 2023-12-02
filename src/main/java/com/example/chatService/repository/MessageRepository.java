package com.example.chatService.repository;

import com.example.chatService.domain.Chatting;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Chatting, String> {
    List<Chatting> findByChatRoomNo(Integer chatRoomNo);
}
