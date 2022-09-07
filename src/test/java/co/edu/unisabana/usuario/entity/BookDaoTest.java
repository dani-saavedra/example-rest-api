package co.edu.unisabana.usuario.entity;

import co.edu.unisabana.usuario.repository.dao.BookDao;
import co.edu.unisabana.usuario.repository.dao.entity.BookEntity;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;
import net.bytebuddy.asm.Advice;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class BookDaoTest {

 BookDao bookDao = new BookDao();
 Book book = new Book("señor de los anillos", 1954, "Tolkien", false, CategoryBook.SOFT_COVER);
 Book book2 = new Book("Maze Runner", 2009, "James Dasher", false, CategoryBook.SOFT_COVER);

    @Test
    public void Given_book_ok_When_registerBook_Then_success() {
        List<BookEntity> list = bookDao.registerBook(book);
        assertEquals(1, list.size());
    }

    @Test
    public void Given_bookName_ok_When_validateExistsBook_Then_return_true(){
        bookDao.registerBook(book);
        assertTrue(bookDao.validateExistsBook(book.getName()));
        }

    @Test
    public void Given_bookName_wrong_When_validateExistsBook_Then_return_flase(){
        bookDao.registerBook(book);
        assertFalse(bookDao.validateExistsBook(book2.getName()));
    }

    @Test
    public void Given_Name_equeals_bookName_When_addBook_Then_return_true(){
        bookDao.registerBook(book);
        assertTrue(bookDao.addBook(book.getName()));
    }
    @Test
    public void Given_Name_not_equeals_bookName_When_addBook_Then_return_exception(){
        bookDao.registerBook(book);
        assertThrows(IllegalArgumentException.class, ()->bookDao.addBook(book2.getName()), "No existe libro para actualizar");

    }


    }

