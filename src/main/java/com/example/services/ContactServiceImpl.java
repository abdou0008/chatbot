package com.example.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.dao.ContactRepository;
import com.example.entities.Contact;

@Service
@jakarta.transaction.Transactional
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public Contact ajouterArticle(Contact contact) {
        return contactRepository.save(contact);
    }

}
