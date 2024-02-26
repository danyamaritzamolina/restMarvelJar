package com.open.pay.restMarvelJar;

import com.open.pay.restMarvelJar.service.CharactersService;
import com.open.pay.restMarvelJar.service.CharactersServiceImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RestMarvelJarApplicationTests {
    // Definición de la clase service para prueba de peticiones a la API
    @Autowired
    CharactersService charactersService = new CharactersServiceImpl();
    long ts = 1;
    @Test
    void contextLoads() {
    }
    
    
    /**
     * Metodo para definir una estructura de datos devuelta con el id 1017100
     * @return 
     */
    public String getDatos(){
        return "{\"code\":200,\"status\":\"Ok\",\"copyright\":\"© 2024 MARVEL\",\"attributionText\":\"Data provided by Marvel. © 2024 MARVEL\",\"attributionHTML\":\"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2024 MARVEL</a>\",\"etag\":\"a0e24d410b8c2da8d79c7da95dd6b4eeeb5b2eea\",\"data\":{\"offset\":0,\"limit\":20,\"total\":1,\"count\":1,\"results\":[{\"id\":1017100,\"name\":\"A-Bomb (HAS)\",\"description\":\"Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\"modified\":\"2013-09-18T15:54:04-0400\",\"thumbnail\":{\"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16\",\"extension\":\"jpg\"},\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1017100\",\"comics\":{\"available\":4,\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/comics\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/47176\",\"name\":\"FREE COMIC BOOK DAY 2013 1 (2013) #1\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40632\",\"name\":\"Hulk (2008) #53\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40630\",\"name\":\"Hulk (2008) #54\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40628\",\"name\":\"Hulk (2008) #55\"}],\"returned\":4},\"series\":{\"available\":2,\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/series\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/17765\",\"name\":\"FREE COMIC BOOK DAY 2013 1 (2013)\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/series/3374\",\"name\":\"Hulk (2008 - 2012)\"}],\"returned\":2},\"stories\":{\"available\":7,\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/stories\",\"items\":[{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92078\",\"name\":\"Hulk (2008) #55\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92079\",\"name\":\"Interior #92079\",\"type\":\"interiorStory\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92082\",\"name\":\"Hulk (2008) #54\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92083\",\"name\":\"Interior #92083\",\"type\":\"interiorStory\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92086\",\"name\":\"Hulk (2008) #53\",\"type\":\"cover\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92087\",\"name\":\"Interior #92087\",\"type\":\"interiorStory\"},{\"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/105929\",\"name\":\"cover from Free Comic Book Day 2013 (Avengers/Hulk) (2013) #1\",\"type\":\"cover\"}],\"returned\":7},\"events\":{\"available\":0,\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/events\",\"items\":[],\"returned\":0},\"urls\":[{\"type\":\"detail\",\"url\":\"http://marvel.com/characters/76/a-bomb?utm_campaign=apiRef&utm_source=bedb423abbba2b263aaa4ff1bcc3a869\"},{\"type\":\"comiclink\",\"url\":\"http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=bedb423abbba2b263aaa4ff1bcc3a869\"}]}]}}";
    }

    /**
     * Test para probar la petición de obtener todos los registros de la api
     * @throws IOException
     * @throws InterruptedException 
     */
    @Test
    public void TestGetAll() throws IOException, InterruptedException{
        ResponseEntity resultado = null;
        
        try {
            
            resultado = charactersService.getAllService(ts);
            System.out.print("URL: "+resultado);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(RestMarvelJarApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        Assertions.assertNotNull(resultado, "La petición retornó valores");
        //Assertions.assertEquals(getDatos(),resultado);
    }
    
    /**
     * Test para probar que la petición por ID devuelva el valor correcto con el id 1017100
     * @throws IOException 
     */

    @Test
    public void TestGetById() throws IOException{
        ResponseEntity resultado = null;
        String characterId = "1017100";
        try {
            resultado = charactersService.getByIdService(characterId,ts);
            System.out.println("RESULTADO: "+resultado.getBody());
        } catch (InterruptedException ex) {
            Logger.getLogger(RestMarvelJarApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        Assertions.assertEquals(getDatos(),resultado.getBody());

    }
    /**
     * Test para probar que la petición por ID devuelva valores
     * @throws IOException 
     */

    @Test
    public void TestGetByIdNotNull() throws IOException{
        ResponseEntity resultado = null;
        String characterId = "1011334";
        try {
            resultado = charactersService.getByIdService(characterId, ts);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestMarvelJarApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        Assertions.assertNotNull(resultado);

    }
   
}
