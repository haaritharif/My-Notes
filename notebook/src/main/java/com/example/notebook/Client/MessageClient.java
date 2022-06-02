package com.example.notebook.Client;

import com.example.notebook.Client.Request.post_message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class handles any external client calls, so that underlying implementation is abstracted
 */
@Service
public class MessageClient {

    @Autowired
    my_Soap_forum my_soap_forum;

    public void saveMessage(String message) {
        post_message post_message = new post_message(new message(message));
        my_soap_forum.post_message(post_message);
    }

}
