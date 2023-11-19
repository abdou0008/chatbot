package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Abonnement;

public interface AbonnementService {

  Abonnement findById(Long abonnementId);
  List<Abonnement> findAll();
  Abonnement saveAbonnement(Abonnement abonnement);
  Abonnement updateAbonnement(Long abonnementId, Abonnement abonnementDetails );
  void deleteAbonnement(Long abonnementId);
}

