package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
}
