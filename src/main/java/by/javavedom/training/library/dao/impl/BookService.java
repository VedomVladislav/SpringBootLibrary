package by.javavedom.training.library.dao.impl;

import by.javavedom.training.library.dao.BookDao;
import by.javavedom.training.library.domain.Book;
import by.javavedom.training.library.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Book> searh(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findAllWithoutContent(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)), searchString[0]);
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }


    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0], searchString[0], new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }


    @Override
    public Book save(Book book) {

        bookRepository.save(book);

        if (book.getContent()!=null) {
            bookRepository.updateContent(book.getContent(), book.getId());
        }

        return book;

    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book get(long id) {
        Optional<Book> bookmark = bookRepository.findById(id);
        if (bookmark.isPresent()) {
            return bookmark.get();
        } else {
            return null;
        }
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContent(id);
    }

    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(new PageRequest(0,limit, new Sort(Sort.Direction.DESC, "viewCount")));
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }


}
