/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.open.pay.restMarvelJar.service;

import java.io.IOException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Interface para el service de consultas de characteres
 * @author danya
 */
@Component
@ComponentScan
public interface CharactersService {
    
    /**
     * Metodo para consultar todas las respuestas de characteres
     * @return 
     */
    
    public ResponseEntity<String> getAllService() throws IOException, InterruptedException;
    
    /**
     * Metodo para consultar charcateres por id
     * @param characterId
     * @return
     */
    public ResponseEntity<String> getByIdService(String characterId)  throws IOException, InterruptedException;
    
    
}
