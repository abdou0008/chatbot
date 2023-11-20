package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.ConversationRepository;
import com.example.chatbot.entities.Conversation;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService{

     @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Conversation findById(Long conversationId) {
        return conversationRepository.findById(conversationId).orElse(null);
    }

    @Override
    public List<Conversation> findAll() {
        return conversationRepository.findAll();
    }

    @Override
    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation updateConversation(Long conversationId, Conversation conversationDetails) {
        Conversation conversation = findById(conversationId);
        if (conversation != null) {
            conversation.setNomConversation(conversationDetails.getNomConversation());

            return conversationRepository.save(conversation);
        }
        return null;
    }

    @Override
    public void deleteConversation(Long conversationtId) {
        conversationRepository.deleteById(conversationtId);
    }
}
