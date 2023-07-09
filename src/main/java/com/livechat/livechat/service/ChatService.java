package com.livechat.livechat.service;

import com.livechat.livechat.dto.request.ChatRequest;
import com.livechat.livechat.dto.response.ChatResponse;
import com.livechat.livechat.entity.ChatEntity;
import java.util.List;
import java.util.Optional;


public interface ChatService {
    List<ChatEntity> findAllChat();
    List<ChatEntity> findAllPublicChat();
    List<ChatEntity> findBySenderName(String senderName);
    List<ChatEntity> findByChatId(String chatId);
    Optional<ChatEntity> findById(Long id);
    ChatEntity saveChat(ChatEntity chatEntity);
    ChatEntity updateChat(ChatEntity chatEntity);
    void deleteChat(Long id);

    ChatResponse saveChat(ChatRequest chatRequest);
    ChatResponse updateChat(ChatRequest chatRequest, Long id);

}
