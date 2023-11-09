package com.example.chatbot.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatbot.sec.entities.AppRole;

public interface AppRoleRepositoriy extends JpaRepository<AppRole,Long> {
   
}
