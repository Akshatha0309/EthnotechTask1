package com.chatapp.websocket;

import com.chatapp.model.Message;
import com.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository repo;

    @MessageMapping("/private")
    @SendTo("/topic/messages")   // ✅ broadcast (works with frontend)
    public Message sendMessage(Message message) {

        // set timestamp
        message.setTimestamp(LocalDateTime.now());

        // save to DB
        repo.save(message);

        // return message to frontend
        return message;
    }
}