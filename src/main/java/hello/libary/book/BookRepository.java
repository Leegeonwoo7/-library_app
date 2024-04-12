package hello.libary.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private static Map<Long, Book> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final BookRepository instance = new BookRepository();

    private BookRepository(){}

    public static BookRepository getInstance() {
        return instance;
    }

    public Book save(Book book){
        book.setId(++sequence);
        store.put(book.getId(), book);
        return book;
    }

    public Book findById(Long id) {
        return store.get(id);
    }

    public List<Book> findByName(String searchName) {
        List<Book> resultList = new ArrayList<>();

        for (Book book : store.values()) {
            if (book.getName().equals(searchName)){
                resultList.add(book);
            }
        }
        return resultList;
    }

    public List<Book> findByGenre(String searchGenre) {
        List<Book> resultList = new ArrayList<>();

        for (Book book : store.values()) {
            if(book.getGenre().equals(searchGenre)){
                resultList.add(book);
            }
        }

//        if (resultList.isEmpty()){
//            throw
//        }
        return resultList;
    }

    //S 테스트용 코드
    public void clear(){
        store.clear();
    }

}
