/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.open.pay.restMarvelJar.controller;

/**
 *
 * @author danya
 */
import com.open.pay.restMarvelJar.service.CharactersService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CharactersController {
    private final static String JSON_RESPONSE = "application/json";
    private final CharactersService charactersService;
    @Autowired
    public CharactersController(CharactersService charactersService) {
        this.charactersService = charactersService;
    }
    
    
    /**
     * Metodo para obtener todos los characteres
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    @GetMapping(value = "/getAll", produces = JSON_RESPONSE)
    public ResponseEntity<String> getAll() throws IOException, InterruptedException {
        ResponseEntity result;
        result = charactersService.getAllService();

        return result;
    }

    
    
    /**
     * Metodo para obtener characteres por id
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    @GetMapping(value = "/getById/{characterId}", produces = JSON_RESPONSE)
    public ResponseEntity<String> getById(@PathVariable String characterId) throws IOException, InterruptedException {
        ResponseEntity result;
        
        result = charactersService.getByIdService(characterId);

        return result;
    }
    
}
