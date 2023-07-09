package com.livechat.livechat.dto.response;

import java.io.Serializable;

public class ChatResponse implements Serializable {
    private String senderName;
    private String message;
    private String chatId;
    public ChatResponse() {
    }
    
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

}
