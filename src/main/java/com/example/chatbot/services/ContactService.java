package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Contact;

public interface ContactService {

  Contact findById(Long contactId);
  List<Contact> findAll();
  Contact saveContact(Contact contact);
  Contact updateContact(Long contactId, Contact contactDetails );
  void deleteContact(Long contactId);
}

