package co.edu.unisabana.usuario.service.library.port;

import co.edu.unisabana.usuario.service.library.model.Book;

import java.util.List;

public interface RegisterBookPort {

    List registerBook(Book newBook);
}

