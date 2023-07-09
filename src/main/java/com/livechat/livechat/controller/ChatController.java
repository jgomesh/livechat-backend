package com.livechat.livechat.controller;

import com.livechat.livechat.entity.ChatEntity;
import com.livechat.livechat.model.Message;
import com.livechat.livechat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ChatService chatService;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        System.out.println(message.toString());
        String messageContent = message.getMessage();
        if (messageContent != null && !messageContent.trim().isEmpty()) {
            ChatEntity chatEntity = new ChatEntity(null, message.getSenderName(), "public", messageContent);
            chatService.saveChat(chatEntity);
        }
        return message;
    }
    
    @MessageMapping("/private-message")
    public Message recMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        String messageContent = message.getMessage();
        if (messageContent != null && !messageContent.trim().isEmpty()) {
            ChatEntity chatEntity = new ChatEntity(null, message.getSenderName(), message.getReceiverName(), messageContent);
            chatService.saveChat(chatEntity);
        }
        return message;
    }
}
