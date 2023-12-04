package com.example.chatService.controller;

import com.example.chatService.config.kafka.KafkaMessageProducer;
import com.example.chatService.domain.Message;
import com.example.chatService.service.ChatRoomService;
import com.example.chatService.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatRoomService chatRoomService;
    private final MessageService messageService;
    private final KafkaMessageProducer kafkaMessageProducer;

    @MessageMapping("/createChatRoom")
    @SendTo("studioi-chatroom")
    public String createChatRoom(@RequestBody String userEmail) {
        chatRoomService.createChatRoom(userEmail);
        return "Chat room created for user: " + userEmail;
    }

    @MessageMapping("/getChatMessages")
    @SendTo("studioi-chat")
    public List<Message> getChatMessages(@RequestBody Integer chatRoomNo) {
        return messageService.getChatMessages(chatRoomNo);
    }

    @MessageMapping("/sendChatMessage")
    public void sendChatMessage(@RequestBody Message message) {
        messageService.saveChatMessage(message);
        kafkaMessageProducer.sendMessage("studioi-chat", message);
    }
}

