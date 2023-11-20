package com.example.chatbot.services;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.dao.ResponseRepository;
import com.example.chatbot.entities.Response;

import jakarta.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ResponseServiceImpl implements ResponseService{

     @Autowired
    private ResponseRepository responseRepository;

    @Override
    public Response findById(Long responseId) {
        return responseRepository.findById(responseId).orElse(null);
    }

    @Override
    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    @Override
    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public Response updateResponse(Long responseId, Response responseDetails) {
        Response response = findById(responseId);
        if (response != null) {
            response.setNomResponse(responseDetails.getNomResponse());

            return responseRepository.save(response);
        }
        return null;
    }

    @Override
    public void deleteResponse(Long responseId) {
    responseRepository.deleteById(responseId);
    }
}
