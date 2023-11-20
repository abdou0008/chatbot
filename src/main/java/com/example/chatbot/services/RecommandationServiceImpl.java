package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.RecommandationRepository;
import com.example.chatbot.entities.Recommandation;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RecommandationServiceImpl implements RecommandationService{

     @Autowired
    private RecommandationRepository recommandationRepository;

    @Override
    public Recommandation findById(Long recommandationId) {
        return recommandationRepository.findById(recommandationId).orElse(null);
    }

    @Override
    public List<Recommandation> findAll() {
        return recommandationRepository.findAll();
    }

    @Override
    public Recommandation saveRecommandation(Recommandation recommandation) {
        return recommandationRepository.save(recommandation);
    }

    @Override
    public Recommandation updateRecommandation(Long recommandationId, Recommandation recommandationDetails) {
        Recommandation recommandation = findById(recommandationId);
        if (recommandation != null) {
            recommandation.setNomRecommandation(recommandationDetails.getNomRecommandation());

            return recommandationRepository.save(recommandation);
        }
        return null;
    }

    @Override
    public void deleteRecommandation(Long recommandationId) {
        recommandationRepository.deleteById(recommandationId);
    }
}
