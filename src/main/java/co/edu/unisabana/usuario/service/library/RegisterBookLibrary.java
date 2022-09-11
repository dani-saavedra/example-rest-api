package co.edu.unisabana.usuario.service.library;

import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.DeleteBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RegisterBookLibrary {

    BookDao bookDao = new BookDao();

    private final SearchBookPort searchBookPort;
    private final AddBookPort addBookPort;
    private final RegisterBookPort registerBookPort;
    private final DeleteBookPort deleteBookPort;

    public RegisterBookLibrary(SearchBookPort searchBookPort, AddBookPort addBookPort, RegisterBookPort registerBookPort, DeleteBookPort deleteBookPort) {
        this.searchBookPort = searchBookPort;
        this.addBookPort = addBookPort;
        this.registerBookPort = registerBookPort;
        this.deleteBookPort = deleteBookPort;
    }


    public int registerBook(Book book) {
        boolean exists = searchBookPort.validateExistsBook(book.getName());
        if (exists) {
            addBookPort.addBook(book.getName());
            return 1;
        } else {
            registerBookPort.registerBook(book);
            return 2;
        }
    }
    public BookEntity findbookbyauthor(String author){
        BookEntity bookEntity = bookDao.getBooks().stream().filter(bookEntity1 -> bookEntity1.getAuthor()
                .equals(author)).findFirst()
                .orElseThrow(() -> new NoSuchElementException());
        return bookEntity;
    }
    public int removebookbyname(String name){
        boolean exists = searchBookPort.validateExistsBook(name);
        if (exists){
            deleteBookPort.removeBook(name);
            return 1;
        }
        return 2;
    }
}
