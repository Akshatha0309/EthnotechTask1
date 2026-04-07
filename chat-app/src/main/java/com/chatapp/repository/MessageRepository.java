package com.chatapp.repository;

import com.chatapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE " +
           "(m.senderId = ?1 AND m.receiverId = ?2) OR " +
           "(m.senderId = ?2 AND m.receiverId = ?1)")
    List<Message> getChat(Long senderId, Long receiverId);
}