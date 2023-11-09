package com.example.chatbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.entities.Response;

public interface ResponseRepository extends JpaRepository<Response,Long> {
}
