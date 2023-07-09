package com.livechat.livechat.repository;

import com.livechat.livechat.entity.ChatUserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatUserRepository extends JpaRepository<ChatUserEntity, Long> {
  Optional<ChatUserEntity> findByName(String name);
}
