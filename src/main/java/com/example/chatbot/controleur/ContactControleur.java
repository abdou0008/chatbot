package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Contact;
import com.example.chatbot.services.ContactService;

import java.util.List;


@RestController
@RequestMapping("/api/contacts")
public class ContactControleur {

    @Autowired
    private ContactService contactService;

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long contactId) {
        Contact contact = contactService.findById(contactId);
        return ResponseEntity.ok().body(contact);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.findAll();
        return ResponseEntity.ok().body(contacts);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long contactId, @RequestBody Contact contactDetails) {
        Contact updateContact = contactService.updateContact(contactId, contactDetails);
        if (updateContact != null) {
            return ResponseEntity.ok().body(updateContact);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.noContent().build();
    }
}
