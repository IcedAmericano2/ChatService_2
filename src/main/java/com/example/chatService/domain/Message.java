package com.example.chatService.domain;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private String id;

    @NotNull
    private Integer chatNo;

    @NotNull
    private String contentType;

    @NotNull
    private String content;

    private String senderName;

    private Integer senderNo;

    private long sendTime;
    private Integer readCount;
    private String senderEmail;

    public void setSendTimeAndSender(LocalDateTime sendTime, Integer senderNo, String senderName, Integer readCount) {
        this.senderName = senderName;
        this.sendTime = sendTime.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();
        this.senderNo = senderNo;
        this.readCount = readCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Chatting convertEntity() {
        return Chatting.builder()
                .senderName(senderName)
                .senderNo(senderNo)
                .chatRoomNo(chatNo)
                .contentType(contentType)
                .content(content)
                .sendDate(Instant.ofEpochMilli(sendTime).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime())
                .readCount(readCount)
                .build();
    }

    public static Message fromEntity(Chatting chatting) {
        return Message.builder()
                .id(chatting.getId())
                .chatNo(chatting.getChatRoomNo())
                .contentType(chatting.getContentType())
                .content(chatting.getContent())
                .senderName(chatting.getSenderName())
                .senderNo(chatting.getSenderNo())
                .sendTime(chatting.getSendDate().atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli())
                .readCount(chatting.getReadCount())
                .senderEmail(chatting.getSenderEmail())
                .build();
    }
}
