package com.example.chatbot.services;

import java.util.List;

import com.example.chatbot.entities.Response;

public interface ResponseService {

  Response findById(Long responseId);
  List<Response> findAll();
  Response saveResponse(Response response);
  Response updateResponse(Long responseId, Response responseDetails );
  void deleteResponse(Long responseId);
}

