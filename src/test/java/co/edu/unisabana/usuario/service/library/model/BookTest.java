package co.edu.unisabana.usuario.service.library.model;

import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import co.edu.unisabana.usuario.AbstractTest;
import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.dto.BookReponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BookTest {


    private final RegisterBookPort registerBookPort;
    private final SearchBookPort searchBookPort;
    private final AddBookPort adddBookPort;
    public BookTest(SearchBookPort searchBookPort, RegisterBookPort registerBookPort, AddBookPort addBookPort) {

        this.registerBookPort = registerBookPort;
        this.searchBookPort = searchBookPort;
        this.adddBookPort = addBookPort;
    }

    @Test
public void Given_Category_Book_When_Registered_Book(){

            CategoryBook category = CategoryBook.fromString("digital");
            Book book = new Book("El señor de los anillos",1954,"J.R Tolkien",false,category);
            Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(true);
            int result = service.registerBook(book);
            Mockito.verify(addBookPort).addBook(book.getName());
            Assertions.assertEquals(1,result);

        }

    }


