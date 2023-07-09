package com.livechat.livechat.dto.mapper;

import com.livechat.livechat.dto.request.ChatRequest;
import com.livechat.livechat.dto.response.ChatResponse;
import com.livechat.livechat.entity.ChatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface LiveChatMapper {
    LiveChatMapper MAPPER = Mappers.getMapper(LiveChatMapper.class);
    
    ChatResponse fromEntityToResponse(ChatEntity chatEntity);
    ChatEntity fromRequestToEntity(ChatRequest chatRequest);
}
