package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Message;

public interface MessageService {

  Message findById(Long messageId);
  List<Message> findAll();
  Message saveMessage(Message message);
  Message updateMessage(Long messageId, Message messageDetails );
  void deleteMessage(Long messageId);
}

