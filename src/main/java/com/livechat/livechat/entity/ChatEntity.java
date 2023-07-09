package com.livechat.livechat.entity;

import javax.persistence.*;

@Entity
@Table(name = "live_chat_db")
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "chat_id")
    private String chatId;
    
    @Column(name = "message")
    private String message;
    public String getChatId() {
        return chatId;
    }
    public String status;
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public ChatEntity() {
    }


    public String getMessage() {
      return message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public ChatEntity(Long id, String senderName, String chatId, String message) {
        this.id = id;
        this.senderName = senderName;
        this.chatId = chatId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setName(String senderName) {
        this.senderName = senderName;
    }
    public void findByName(String senderName) {
        this.senderName = senderName;
    }
}
