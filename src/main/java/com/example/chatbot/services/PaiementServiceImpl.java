package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.PaiementRepository;
import com.example.chatbot.entities.Paiement;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService{

     @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement findById(Long paiementId) {
        return paiementRepository.findById(paiementId).orElse(null);
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement updatePaiement(Long paiementId, Paiement paiementDetails) {
        Paiement paiement = findById(paiementId);
        if (paiement != null) {
            paiement.setTypePaiement(paiementDetails.getTypePaiement());

            return paiementRepository.save(paiement);
        }
        return null;
    }

    @Override
    public void deletePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);
    }
}
