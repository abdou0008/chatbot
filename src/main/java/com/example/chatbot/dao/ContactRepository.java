package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact,Long> {

}
