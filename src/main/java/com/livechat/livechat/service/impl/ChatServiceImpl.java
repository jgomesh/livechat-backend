package com.livechat.livechat.service.impl;

import com.livechat.livechat.dto.mapper.LiveChatMapper;
import com.livechat.livechat.dto.request.ChatRequest;
import com.livechat.livechat.dto.response.ChatResponse;
import com.livechat.livechat.entity.ChatEntity;
import com.livechat.livechat.repository.ChatRepository;
import com.livechat.livechat.service.ChatService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public List<ChatEntity> findAllChat() {
        return chatRepository.findAll();
    }
    
    @Override
    public List<ChatEntity> findAllPublicChat() {
        List<ChatEntity> allChats = chatRepository.findAll();
        List<ChatEntity> publicChats = new ArrayList<>();

        for (ChatEntity chat : allChats) {
            if (chat.getChatId().equals("public")) {
                publicChats.add(chat);
            }
        }

        return publicChats;
    }

    @Override
    public Optional<ChatEntity> findById(Long id) {
        return chatRepository.findById(id);
    }

    @Override
    public List<ChatEntity> findBySenderName(String senderName) {
        return chatRepository.findBySenderName(senderName);
    }

    @Override
    public List<ChatEntity> findByChatId(String chatId) {
        return chatRepository.findByChatId(chatId);
    }
    @Override
    public ChatEntity saveChat(ChatEntity chatEntity) {
        return chatRepository.save(chatEntity);
    }

    @Override
    public ChatEntity updateChat(ChatEntity chatEntity) {
        return chatRepository.save(chatEntity);
    }

    @Override
    public void deleteChat(Long id) {
        chatRepository.deleteById(id);
    }

    @Override
    public ChatResponse saveChat(ChatRequest chatRequest) {
        ChatEntity chatEntity = LiveChatMapper.MAPPER.fromRequestToEntity(chatRequest);
        chatRepository.save(chatEntity);
        return LiveChatMapper.MAPPER.fromEntityToResponse(chatEntity);
    }

    @Override
    public ChatResponse updateChat(ChatRequest chatRequest, Long id) {

        Optional<ChatEntity> checkExistingChat = findById(id);
        if (! checkExistingChat.isPresent())
            throw new RuntimeException("Chat Id "+ id + " Not Found!");

        ChatEntity chatEntity = LiveChatMapper.MAPPER.fromRequestToEntity(chatRequest);
        chatEntity.setId(id);
        chatRepository.save(chatEntity);
        return LiveChatMapper.MAPPER.fromEntityToResponse(chatEntity);
    }
    
}
