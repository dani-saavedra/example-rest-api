package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.dto.BookReponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest extends AbstractTest{
    @Autowired
    private TestRestTemplate restTemplate;

    private static final String PATH_REGISTER ="/book/register";

    private static final String Path_DATOS ="/book/search";

    @Test
    public void Given_When_Then(){
        BookDto dto = new BookDto("GOT",1996,"George R.R","Comercial","suave");

        ResponseEntity<BookReponse> result = restTemplate.postForEntity(PATH_REGISTER, dto ,BookReponse.class);
        assertEquals("Nuevo libro registrado", result.getBody().getData());
    }


    @Test
    public void Given_Wrong_information_When_callDatos_Then_return_empty(){
        ResponseEntity<BookReponse> result = restTemplate.getForEntity(Path_DATOS, BookReponse.class);
        assertFalse(result.getBody().getData().isEmpty());
    }
}
