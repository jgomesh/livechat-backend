package com.livechat.livechat.dto.mapper;

import com.livechat.livechat.dto.request.ChatUserRequest;
import com.livechat.livechat.dto.response.ChatUserResponse;
import com.livechat.livechat.entity.ChatUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatUserMapper {
    ChatUserMapper MAPPER = Mappers.getMapper(ChatUserMapper.class);
    ChatUserEntity fromRequestToEntity(ChatUserRequest chatUserRequest);
    ChatUserResponse fromEntityToResponse(ChatUserEntity chatUserEntity);
    
}
