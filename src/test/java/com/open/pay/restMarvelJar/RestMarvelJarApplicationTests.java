package com.open.pay.restMarvelJar;

import com.open.pay.restMarvelJar.service.CharactersServiceImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RestMarvelJarApplicationTests {
    
    CharactersServiceImpl charactersService = new CharactersServiceImpl();

    @Test
    void contextLoads() {
    }

    @Test
    public void TestGetAll() throws IOException, InterruptedException{
        ResponseEntity resultado = null;
        /*try {
            resultado = charactersService.getAllService();
        } catch (InterruptedException ex) {
            Logger.getLogger(RestMarvelJarApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }*/
        //Assertions.assertNotNull(resultado);
    }

    @Test
    public void TestGetById() throws IOException{
        ResponseEntity resultado = null;
        String characterId = "1011334";
        /*try {
            resultado = charactersService.getByIdService(characterId);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestMarvelJarApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }*/
        //Assertions.assertNotNull(resultado);

    }
}
