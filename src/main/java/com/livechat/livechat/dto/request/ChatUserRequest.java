package com.livechat.livechat.dto.request;

import java.io.Serializable;

public class ChatUserRequest implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
