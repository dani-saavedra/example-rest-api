package co.edu.unisabana.usuario.repository.dao.entity;

import co.edu.unisabana.usuario.service.library.model.Book;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {

    private String name;
    private int year;
    private String author;
    private boolean rRated;
    private String category;
    @Id
    private Integer id;
    private int quantity;

    public BookEntity(String name, int year, String author, boolean rRated, String category, int quantity) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.rRated = rRated;
        this.category = category;
        this.quantity = quantity;
    }

    public static BookEntity fromModel(Book book) {
        return new BookEntity(book.getName(), book.getYear(), book.getAuthor(), book.isRRated(), book.getCategory().name(), 1);
    }
}
