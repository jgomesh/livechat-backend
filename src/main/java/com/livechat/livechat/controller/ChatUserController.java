package com.livechat.livechat.controller;

import com.livechat.livechat.dto.request.ChatUserRequest;
import com.livechat.livechat.dto.response.ChatUserResponse;
import com.livechat.livechat.entity.ChatUserEntity;
import com.livechat.livechat.service.ChatUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/chat-user-register")
public class ChatUserController {

    private final ChatUserService chatUserService;

    public ChatUserController(ChatUserService chatUserService) {
        this.chatUserService = chatUserService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<ChatUserEntity> findAllChatUser() {
        return chatUserService.findAllChatUser();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<ChatUserEntity> findChatUserById(@PathVariable("id") Long id) {
        return chatUserService.findById(id);
    }

    @GetMapping("/user/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<ChatUserEntity> findChatUserByName(@PathVariable("name") String name) {
        return chatUserService.findByName(name);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ChatUserEntity saveChatUser(@RequestBody ChatUserEntity chatUserEntity) {
        return chatUserService.saveChatUser(chatUserEntity);
    }

    @PutMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ChatUserEntity updateChatUser(@RequestBody ChatUserEntity chatUserEntity) {
        return chatUserService.updateChatUser(chatUserEntity);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteChatUser(@PathVariable("id") Long id) {
        chatUserService.deleteChatUser(id);
    }

    @PostMapping("/res")
    @CrossOrigin(origins = "http://localhost:3000")
    public ChatUserResponse saveEmpResponse(@RequestBody ChatUserRequest chatUserRequest) {
        return chatUserService.saveChatUser(chatUserRequest);
    }

    @PutMapping("/res/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ChatUserResponse updateEmpResponse(@RequestBody ChatUserRequest chatUserRequest, @PathVariable("id") Long id) {
        return chatUserService.updateChatUser(chatUserRequest, id);
    }

}
