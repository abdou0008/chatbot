package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Recommandation;

public interface RecommandationService {

  Recommandation findById(Long recommadationId);
  List<Recommandation> findAll();
  Recommandation saveRecommandation(Recommandation recommandation);
  Recommandation updateRecommandation(Long recommandation, Recommandation recommandationDetails );
  void deleteRecommandation(Long recommandationId);
}

