package com.example.chatService.config.jwtIntercepter;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

public class HandlerInterceptorAdapter implements ChannelInterceptor {

    private final HandlerInterceptor handlerInterceptor;

    public HandlerInterceptorAdapter(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        try {
            handlerInterceptor.preHandle(null, null, null);
        } catch (Exception e) {
            // 예외 처리
        }
        return message;
    }
}

