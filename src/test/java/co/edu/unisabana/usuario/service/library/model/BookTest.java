package co.edu.unisabana.usuario.service.library.model;

import co.edu.unisabana.usuario.service.library.RegisterBookLibrary;
import co.edu.unisabana.usuario.service.library.port.RegisterBookPort;
import co.edu.unisabana.usuario.service.library.port.SearchBookPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import co.edu.unisabana.usuario.service.library.port.AddBookPort;


class BookTest {

    @InjectMocks
    private RegisterBookLibrary registerBookLibrary;
    @Mock
    private  RegisterBookPort registerBookPort;
    @Mock
    private  SearchBookPort searchBookPort;
    @Mock
    private  AddBookPort addBookPort;

    @Test
public void Given_Category_Book_When_Registered_Book(){

            CategoryBook category = CategoryBook.fromString("digital");
            Book book = new Book("El señor de los anillos",1954,"J.R Tolkien",false,category);
            Mockito.when(searchBookPort.validateExistsBook(book.getName())).thenReturn(true);
            int result = registerBookLibrary.registerBook(book);
            Mockito.verify(addBookPort).addBook(book.getName());
            Assertions.assertEquals(1,result);

        }

    }


