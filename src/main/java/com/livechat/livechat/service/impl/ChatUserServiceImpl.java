package com.livechat.livechat.service.impl;

import com.livechat.livechat.dto.mapper.ChatUserMapper;
import com.livechat.livechat.dto.request.ChatUserRequest;
import com.livechat.livechat.dto.response.ChatUserResponse;
import com.livechat.livechat.entity.ChatUserEntity;
import com.livechat.livechat.repository.ChatUserRepository;
import com.livechat.livechat.service.ChatUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public class ChatUserServiceImpl implements ChatUserService {

    private final ChatUserRepository chatUserRepository;

    public ChatUserServiceImpl(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    @Override
    public List<ChatUserEntity> findAllChatUser() {
        return chatUserRepository.findAll();
    }

    @Override
    public Optional<ChatUserEntity> findById(Long id) {
        return chatUserRepository.findById(id);
    }

    @Override
    public Optional<ChatUserEntity> findByName(String name) {
        return chatUserRepository.findByName(name);
    }
@Override
public ChatUserEntity saveChatUser(ChatUserEntity chatUserEntity) {
    Optional<ChatUserEntity> checkExistingChatUser = findByName(chatUserEntity.getName());
    if (checkExistingChatUser.isPresent()) {
        ChatUserEntity existingUser = checkExistingChatUser.get();
        existingUser.setExists(true);
        return existingUser;
    }
    chatUserEntity.setExists(false);
    return chatUserRepository.save(chatUserEntity);
}

    @Override
    public ChatUserEntity updateChatUser(ChatUserEntity chatUserEntity) {
        return chatUserRepository.save(chatUserEntity);
    }

    @Override
    public void deleteChatUser(Long id) {
        chatUserRepository.deleteById(id);
    }

    @Override
    public ChatUserResponse saveChatUser(ChatUserRequest chatUserRequest) {
        ChatUserEntity chatUserEntity = ChatUserMapper.MAPPER.fromRequestToEntity(chatUserRequest);
  
        chatUserRepository.save(chatUserEntity);
        return ChatUserMapper.MAPPER.fromEntityToResponse(chatUserEntity);
    }

    @Override
    public ChatUserResponse updateChatUser(ChatUserRequest chatUserRequest, Long id) {

        Optional<ChatUserEntity> checkExistingChatUser = findById(id);
        if (!checkExistingChatUser.isPresent())
            throw new RuntimeException("ChatUser Id "+ id + " Not Found!");

        ChatUserEntity chatUserEntity = ChatUserMapper.MAPPER.fromRequestToEntity(chatUserRequest);
        chatUserEntity.setId(id);
        chatUserRepository.save(chatUserEntity);
        return ChatUserMapper.MAPPER.fromEntityToResponse(chatUserEntity);
    }

}
