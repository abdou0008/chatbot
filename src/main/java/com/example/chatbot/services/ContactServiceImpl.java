package com.example.chatbot.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.ContactRepository;
import com.example.chatbot.entities.Contact;

@Service
@jakarta.transaction.Transactional
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public Contact ajouterArticle(Contact contact) {
        return contactRepository.save(contact);
    }

}
