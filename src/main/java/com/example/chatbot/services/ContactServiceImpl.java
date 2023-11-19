package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.ContactRepository;
import com.example.chatbot.entities.Contact;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{

     @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact findById(Long contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long contactId, Contact contactDetails) {
        Contact contact = findById(contactId);
        if (contact != null) {
            contact.setNomContact(contactDetails.getNomContact());
            contact.setAdresseContact(contactDetails.getAdresseContact());
            contact.setEmailContact(contactDetails.getEmailContact());
            // Ajouter d'autres champs à mettre à jour si nécessaire

            return contactRepository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
