package com.example.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec.entities.AppRole;

public interface AppRoleRepositoriy extends JpaRepository<AppRole,Long> {

    AppRole findByRoleName(String roleName);
   
}
