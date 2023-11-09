package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
