package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
}
