package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.AbonnementRepository;
import com.example.chatbot.entities.Abonnement;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AbonnementServiceImpl implements AbonnementService{

     @Autowired
    private AbonnementRepository abonnementRepository;

    @Override
    public Abonnement findById(Long abonnementId) {
        return abonnementRepository.findById(abonnementId).orElse(null);
    }

    @Override
    public List<Abonnement> findAll() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Long abonnementId, Abonnement abonnementDetails) {
        Abonnement abonnement = findById(abonnementId);
        if (abonnement != null) {
            abonnement.setNomAbonnement(abonnementDetails.getNomAbonnement());

            return abonnementRepository.save(abonnement);
        }
        return null;
    }

    @Override
    public void deleteAbonnement(Long abonnementId) {
        abonnementRepository.deleteById(abonnementId);
    }
}
