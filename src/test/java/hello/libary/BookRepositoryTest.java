package hello.libary;

import hello.libary.book.Book;
import hello.libary.book.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BookRepositoryTest {

    BookRepository bookRepository = BookRepository.getInstance();

    @BeforeEach
    void setUp(){
        Book java1 = new Book("java", "Language"); //id = 1
        Book java2 = new Book("java", "ETC"); //id = 2
        Book mysql = new Book("mysql", "DB"); //id = 3
        Book oracle = new Book("oracle", "DB"); //id = 4

        bookRepository.save(java1);
        bookRepository.save(java2);
        bookRepository.save(mysql);
        bookRepository.save(oracle);
    }

    @AfterEach
    void clear(){
        bookRepository.clear();
    }

    @Test
    @DisplayName("모든 책 검색")
    void findAllTest(){
        List<Book> bookList = bookRepository.findAll();
        assertThat(bookList.size()).isSameAs(4);
    }

    @Test
    @DisplayName("ID로 책 검색")
    void findByIdTest(){
        Book book = new Book("spring", "Framework");
        Book springBook = bookRepository.save(book);

        assertThat(springBook).isEqualTo(bookRepository.findById(5L));
    }

    @Test
    @DisplayName("이름으로 책 검색")
    void findByNameTest(){
        int size = bookRepository.findByName("java").size();
        assertThat(size).isSameAs(2);
    }

    @Test
    @DisplayName("장르로 책 검색")
    void findByGenreTest(){
        int size = bookRepository.findByGenre("DB").size();
        assertThat(size).isSameAs(2);
    }

    @Test
    @DisplayName("아이디로 책 삭제")
    void deleteByIdTest(){
        assertThat(bookRepository.findAll().size()).isSameAs(4);

        bookRepository.deleteById(4L);
        assertThat(bookRepository.findAll().size()).isSameAs(3);

        assertThat(bookRepository.findById(4L)).isNull();
    }
}
