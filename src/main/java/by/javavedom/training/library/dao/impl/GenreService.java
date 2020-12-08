package by.javavedom.training.library.dao.impl;


import by.javavedom.training.library.dao.GenreDao;
import by.javavedom.training.library.domain.Genre;
import by.javavedom.training.library.spring.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService implements GenreDao {


    @Autowired
    private GenreRepository genreRepository;


    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }


    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Genre> searh(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return genreRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)), searchString[0]);
    }


    @Override
    public List<Genre> search(String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }


    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);

    }

    @Override
    public Genre get(long id) {
        Optional<Genre> bookmark = genreRepository.findById(id);
        if (bookmark.isPresent()) {
            return bookmark.get();
        } else {
            return null;
        }
    }
}

