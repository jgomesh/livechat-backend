package com.livechat.livechat.controller;

import com.livechat.livechat.entity.ChatEntity;
import com.livechat.livechat.service.ChatService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messages")
public class MessagesController {

    private final ChatService chatService;

    public MessagesController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/public")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ChatEntity> findAllPublicChat() {
        return chatService.findAllPublicChat();
    }
    @GetMapping("/private/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ChatEntity> findAllPrivateChat(@PathVariable("name") String name) {
        List<ChatEntity> chatsBySenderName = chatService.findBySenderName(name);
        List<ChatEntity> chatsByChatId = chatService.findByChatId(name);
        List<ChatEntity> mergedChats = new ArrayList<>();

        for (ChatEntity chat : chatsBySenderName) {
            if (!chat.getChatId().equals("public")) {
                mergedChats.add(chat);
            }
        }

        for (ChatEntity chat : chatsByChatId) {
            if (!chat.getChatId().equals("public")) {
                mergedChats.add(chat);
            }
        }

        mergedChats.sort(Comparator.comparing(ChatEntity::getId));

        return mergedChats;
    }

}
