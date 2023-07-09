package com.livechat.livechat.repository;

import com.livechat.livechat.entity.ChatEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {
  List<ChatEntity> findBySenderName(String senderName);
   List<ChatEntity> findByChatId(String chatId);
}
