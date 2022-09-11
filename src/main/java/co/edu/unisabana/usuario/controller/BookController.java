package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.dto.BookReponse;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/book")
public class BookController {

    private final RegisterBookLibrary registerBookLibrary;


    public BookController(RegisterBookLibrary registerBookLibrary) {
        this.registerBookLibrary = registerBookLibrary;
    }

    // Pendiente validar uso de exception handler
    // explicar camel case
    @PostMapping("/register")
    @ResponseBody
    public BookReponse registerBook(@RequestBody BookDto bookDto) {
        int result = registerBookLibrary.registerBook(bookDto.toModel());
        if (result == 1) {
            return new BookReponse("Actualizada cantidad");
        }
        return new BookReponse("Nuevo libro registrado");
    }
    /*@GetMapping("/search/{author}")
    public ArrayList<BookEntity> findbookbyauthor(@PathVariable String author){
        return registerBookLibrary.findbookbyauthor();
    }*/
    @GetMapping("search/{author}")
    BookEntity bookEntity(@PathVariable String author){
        if (Objects.isNull(registerBookLibrary.findbookbyauthor(author))) {
            throw new IllegalArgumentException("Escriba un autor valido");
        } else {
            return registerBookLibrary.findbookbyauthor(author);
        }
    }
    @DeleteMapping(value = "remove/{name}")
    int bookEntitydelete(@PathVariable String name){
        if (Objects.isNull(registerBookLibrary.removebookbyname(name))) {
            throw new IllegalArgumentException("Escriba un nombre valido");
        } else {
            return registerBookLibrary.removebookbyname(name);
        }
    }
}
