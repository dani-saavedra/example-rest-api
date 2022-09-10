package co.edu.unisabana.usuario.logica;

import co.edu.unisabana.usuario.dto.BookDto;
import co.edu.unisabana.usuario.service.library.model.Book;
import co.edu.unisabana.usuario.service.library.model.CategoryBook;


import java.util.ArrayList;
import java.util.List;

public class LogicaNegocio {
    private final static LogicaNegocio logicaDeNegocio = new LogicaNegocio();
    private final List<Book> listado = new ArrayList<>();


    private LogicaNegocio(){
        Book book1 = new Book("El señor de los anillos", 1954,"J.R. Tolkien", false, CategoryBook.SOFT_COVER);
        Book book2 = new Book("El señor de los anillos 2", 1963,"J.R. Tolkien", false, CategoryBook.HARD_COVER);
        listado.add(book1);
        listado.add(book2);
    }

    public static LogicaNegocio getInstance(){
        return logicaDeNegocio;
    }

    public List<Book> getListado(){
        return listado;

    }


}
