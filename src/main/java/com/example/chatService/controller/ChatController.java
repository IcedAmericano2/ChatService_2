package com.example.chatService.controller;

import com.example.chatService.domain.Message;
import com.example.chatService.service.ChatRoomService;
import com.example.chatService.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomService chatRoomService;
    private final MessageService messageService;

    @MessageMapping("/createChatRoom")
    @SendTo("/topic/chatRoomCreated")
    public String createChatRoom(String userEmail) {
        chatRoomService.createChatRoom(userEmail);
        return "Chat room created for user: " + userEmail;
    }

    @MessageMapping("/getChatMessages")
    @SendTo("/topic/chatMessages")
    public List<Message> getChatMessages(Integer chatRoomNo) {
        return messageService.getChatMessages(chatRoomNo);
    }

    @MessageMapping("/sendChatMessage")
    public void sendChatMessage(Message message) {
        messageService.saveChatMessage(message);
    }
}

