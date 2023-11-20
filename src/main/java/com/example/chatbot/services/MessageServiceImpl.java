package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.MessageRepository;
import com.example.chatbot.entities.Message;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MessageServiceImpl implements MessageService{

     @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message findById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long messageId, Message messageDetails) {
        Message message = findById(messageId);
        if (message != null) {
            message.setNomMessage(messageDetails.getNomMessage());

            return messageRepository.save(message);
        }
        return null;
    }

    @Override
    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
