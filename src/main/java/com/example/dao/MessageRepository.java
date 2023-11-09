package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
}