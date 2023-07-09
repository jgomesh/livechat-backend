package com.livechat.livechat.dto.response;

import java.io.Serializable;

public class ChatUserResponse implements Serializable {
    private Long id;
    private String name;

    public ChatUserResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
