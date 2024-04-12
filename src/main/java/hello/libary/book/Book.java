package hello.libary.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class Book {
    private Long id;
    private String name;
    private String genre;

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }
}
