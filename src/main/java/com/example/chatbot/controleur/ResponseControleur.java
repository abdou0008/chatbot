package com.example.chatbot.controleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.chatbot.entities.Response;
import com.example.chatbot.services.ResponseService;

import java.util.List;


@RestController
@RequestMapping("/api/response")
public class ResponseControleur {

    @Autowired
    private ResponseService responseService;

    @GetMapping("/{responseId}")
    public ResponseEntity<Response> getResponseById(@PathVariable Long responseId) {
        Response response = responseService.findById(responseId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<Response>> getAllResponses() {
        List<Response> responses =  responseService.findAll();
        return ResponseEntity.ok().body(responses);
    }

    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {
        Response createdResponse = responseService.saveResponse(response);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResponse);
    }

    @PutMapping("/{responseId}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long responseId, @RequestBody Response responseDetails) {
        Response updateResponse = responseService.updateResponse(responseId, responseDetails);
        if (updateResponse != null) {
            return ResponseEntity.ok().body(updateResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{responseId}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long responseId) {
        responseService.deleteResponse(responseId);
        return ResponseEntity.noContent().build();
    }
}
