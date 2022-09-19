package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.Book;

//snake_case
//CamelCase
public class ClasePrueba {

    RepositoryBook repositoryBook;

    public ClasePrueba(RepositoryBook repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public Book guardar(String author, String categoria) {
        Book book = new Book(author, categoria);
        int i = repositoryBook.guardarLibro(book);
        book.setNumero(i);
        return book;
    }

    public int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public String obtenerMensaje(int numero) {
        if (numero % 2 == 0) {
            return "hola";
        } else {
            return "chao";
        }
    }

    public boolean esMayorDe5(int numero) {
        return numero > 5;
    }


    public int registrarLibro(Book book) {
        if ("Violencia".equals(book.getCategory())) {
            return 0;
        } else {
            //regitramos......bla bla
            return 1;
        }
    }
}
