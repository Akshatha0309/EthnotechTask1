package com.chatapp.controller;

import com.chatapp.model.Message;
import com.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository repo;

    // ✅ GET ALL CHAT HISTORY
    @GetMapping
    public List<Message> getAllMessages() {
        return repo.findAll();
    }
    @PostMapping
public Message saveMessage(@RequestBody Message message) {
     message.setTimestamp(LocalDateTime.now()); 
    return repo.save(message);
}

@GetMapping("/chat")
public List<Message> getChatBetweenUsers(
        @RequestParam Long senderId,
        @RequestParam Long receiverId
) {
    return repo.getChat(senderId, receiverId);
}
}