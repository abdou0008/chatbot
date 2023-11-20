package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Conversation;
import com.example.chatbot.services.ConversationService;

import java.util.List;


@RestController
@RequestMapping("/api/conversations")
public class ConversationControleur {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/{conversationId}")
    public ResponseEntity<Conversation> getConversationById(@PathVariable Long conversationId) {
        Conversation conversation = conversationService.findById(conversationId);
        return ResponseEntity.ok().body(conversation);
    }

    @GetMapping
    public ResponseEntity<List<Conversation>> getAllConversations() {
        List<Conversation> conversations = conversationService.findAll();
        return ResponseEntity.ok().body(conversations);
    }

    @PostMapping
    public ResponseEntity<Conversation> createConversation(@RequestBody Conversation conversation) {
        Conversation createdConversation = conversationService.saveConversation(conversation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConversation);
    }

    @PutMapping("/{conversationId}")
    public ResponseEntity<Conversation> updateConversation(@PathVariable Long conversationId, @RequestBody Conversation conversationDetails) {
        Conversation updateConversation = conversationService.updateConversation(conversationId, conversationDetails);
        if (updateConversation != null) {
            return ResponseEntity.ok().body(updateConversation);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{conversationId}")
    public ResponseEntity<Void> deleteConversation(@PathVariable Long conversationId) {
        conversationService.deleteConversation(conversationId);
        return ResponseEntity.noContent().build();
    }
}
