package com.example.notebook.Client.Request;

import com.example.notebook.Client.message;

public class post_message {
    private message message;

    public post_message(message message) {
        this.message = message;
    }

    public message getMessage() {
        return message;
    }

    public void setMessage(message message) {
        this.message = message;
    }
}
