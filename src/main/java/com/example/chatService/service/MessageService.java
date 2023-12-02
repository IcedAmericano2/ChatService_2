package com.example.chatService.service;

import com.example.chatService.domain.Chatting;
import com.example.chatService.domain.Message;
import com.example.chatService.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getChatMessages(Integer chatRoomNo) {
        List<Chatting> chatMessages = messageRepository.findByChatRoomNo(chatRoomNo);
        return chatMessages.stream().map(Message::fromEntity).collect(Collectors.toList());
    }

    public void saveChatMessage(Message message) {
        Chatting chatMessage = message.convertEntity();
        chatMessage.setSendDate(LocalDateTime.now());
        messageRepository.save(chatMessage);
    }
}
