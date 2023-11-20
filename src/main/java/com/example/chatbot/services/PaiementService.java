package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Paiement;

public interface PaiementService {

  Paiement findById(Long paiementId);
  List<Paiement> findAll();
  Paiement savePaiement(Paiement paiement);
  Paiement updatePaiement(Long paiementId, Paiement paiementDetails );
  void deletePaiement(Long paiementId);
}

