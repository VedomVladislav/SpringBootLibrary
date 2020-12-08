package by.javavedom.training.library.dao;

import by.javavedom.training.library.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookDao extends GeneralDao<Book> {

    List<Book> findTopBooks(int limit);

    byte[] getContent(long id);

    //постраничный вывод книг определенного жанра
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);

}
