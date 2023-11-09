package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Response;

public interface ResponseRepository extends JpaRepository<Response,Long> {
}
