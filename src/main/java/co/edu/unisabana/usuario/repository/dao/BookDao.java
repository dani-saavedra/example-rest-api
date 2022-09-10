package co.edu.unisabana.usuario.repository.dao;

import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class BookDao implements SearchBookPort, RegisterBookPort, AddBookPort {

    static List<BookEntity> listBooks = new ArrayList<>();

    @Override
    public boolean validateExistsBook(String nameBook) {
        AtomicBoolean exists = new AtomicBoolean(false);
        listBooks.forEach(book -> {
            if (book.getName().equals(nameBook)) {
                exists.set(true);
            }
        });
        return exists.get();
    }

    @Override
    public List<BookEntity> searchBook(String autor) {
        List<BookEntity> resultados = new ArrayList<>();
        listBooks.forEach(dato -> {
            if (dato.getAuthor().contains(autor)) {
                resultados.add(dato);
            }
        });
       return resultados;
    }


    @Override
    public List registerBook(Book newBook) {
        BookEntity bookEntity = BookEntity.fromModel(newBook);
        bookEntity.setId(listBooks.size() + 1);
        listBooks.add(bookEntity);
        return listBooks;

    }

    @Override
    public boolean addBook(String name) {
        for (BookEntity book : listBooks) {
            if (book.getName().equals(name) && quantityCheck(book)) {
                    book.setQuantity(book.getQuantity() + 1);
                    return true;
            }
        }
        throw new IllegalArgumentException("No existe libro para actualizar o numero maximo alcanzado");
    }

    public boolean quantityCheck (BookEntity book){
        if (book.getQuantity() < 10){
            return true;
        }
        return false;
    }
}
