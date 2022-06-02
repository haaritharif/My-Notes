package com.example.notebook.Client;

import com.example.notebook.Client.Request.post_message;
import com.example.notebook.Client.Response.returns_resultcode;
import org.springframework.stereotype.Service;

@Service
public class my_Soap_forum {

    /**
     * This method contains our mock - ideally we would have an external client call that would
     * return a real value
     * @param post_message
     * @return
     */
    public returns_resultcode post_message(post_message post_message) {
        returns_resultcode returns_resultcode = new returns_resultcode(new resultcode("200"));
        return returns_resultcode;
    }
}
