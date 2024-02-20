/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.open.pay.restMarvelJar.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Service para consulta de peticiones a api de marvel
 * @author danya
 */
@Service
@Component
@ComponentScan
public class CharactersServiceImpl implements CharactersService{
    
    @Value("${marvel.api.public-key}")
    public String publicKey;

    @Value("${marvel.api.private-key}")
    public String privateKey;

    @Value("${marvel.api.base-url}")
    public String baseUrl;
    
    
    /**
     * Metodo para consultar todas las respuestas de characteres
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    @Override
    public ResponseEntity<String> getAllService() throws IOException, InterruptedException {
        String result = "";
        
        String url = generateUrl(System.currentTimeMillis(),null);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        result = response.body();

        return ResponseEntity.ok(result);
    }
    /**
     * Metodo para consultar charcateres por id
     * @param characterId
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    @Override
    public ResponseEntity<String> getByIdService(String characterId) throws IOException, InterruptedException {
        String result = "";
        String url = generateUrl(System.currentTimeMillis(), characterId);
        System.out.print("URL: "+url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        result = response.body();

        return ResponseEntity.ok(result);
    }
    
    /**
     * Metodo para generar url
     * @param ts timestamp tiempo de consulta
     * @param param id para consulta por id
     * @return 
     */
    public String generateUrl(long ts, String param) {
        return baseUrl + (param!=null?"/"+param:"")+"?ts=" + ts + "&apikey=" + publicKey + "&hash=" + generate(ts, privateKey, publicKey);
    }
	
    /**
     * Metodo para generar hash md5
     * @param ts Timestamp
     * @param privateKey llave privada
     * @param publicKey llave publica
     * @return 
     */
    public String generate(long ts, String privateKey, String publicKey) {
        String password = ts + privateKey + publicKey;
        return DigestUtils.md5Hex(password);
    }
    
}
