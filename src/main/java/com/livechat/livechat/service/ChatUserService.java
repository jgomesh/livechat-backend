package com.livechat.livechat.service;

import com.livechat.livechat.dto.request.ChatUserRequest;
import com.livechat.livechat.dto.response.ChatUserResponse;
import com.livechat.livechat.entity.ChatUserEntity;
import java.util.List;
import java.util.Optional;


public interface ChatUserService {
    List<ChatUserEntity> findAllChatUser();
    Optional<ChatUserEntity> findById(Long id);
    Optional<ChatUserEntity> findByName(String name);
    ChatUserEntity saveChatUser(ChatUserEntity chatUserEntity);
    ChatUserEntity updateChatUser(ChatUserEntity chatUserEntity);
    void deleteChatUser(Long id);

    ChatUserResponse saveChatUser(ChatUserRequest chatUserRequest);
    ChatUserResponse updateChatUser(ChatUserRequest chatUserRequest, Long id);

}
