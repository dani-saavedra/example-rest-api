package co.edu.unisabana.usuario.service.library.model;

import lombok.Getter;

@Getter

public class Book {

    private String name;
    private int year;
    private String author;
    private boolean rRated;
    private CategoryBook category;


    public Book(String name, int year, String author, boolean rRated, CategoryBook category) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.rRated = rRated;
        this.category = category;
    }

    public Book() {

    }

    public void setName() {
    }

    public void setCategory() {
    }
}
