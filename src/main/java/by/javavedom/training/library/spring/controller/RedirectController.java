package by.javavedom.training.library.spring.controller;

import by.javavedom.training.library.spring.repository.AuthorRepository;
import by.javavedom.training.library.spring.repository.BookRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log
public class RedirectController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        authorRepository.findAll();
        bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName("ò", "ä");
//        Page<Book> bookList = bookRepository.findAllWithoutContent(new PageRequest(0, 10, new Sort(Sort.Direction.ASC,  "name")));
//        Page<Book> bookPage = bookRepository.findByGenre(20, new PageRequest(0, 10, new Sort(Sort.Direction.ASC,  "name")));
        return "ok";
    }

}
