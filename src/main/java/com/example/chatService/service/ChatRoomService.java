package com.example.chatService.service;

import com.example.chatService.domain.ChatRoom;
import com.example.chatService.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public ChatRoom createChatRoom(String userEmail) {
        Optional<ChatRoom> existingChatRoom = chatRoomRepository.findByUserEmail(userEmail);
        return existingChatRoom.orElseGet(() -> chatRoomRepository.save(new ChatRoom(userEmail)));
    }
}
