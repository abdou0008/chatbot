package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Conversation;

public interface ConversationService {

  Conversation findById(Long conversationId);
  List<Conversation> findAll();
  Conversation saveConversation(Conversation conversation);
  Conversation updateConversation(Long conversationId, Conversation conversationDetails );
  void deleteConversation(Long conversationId);
}

