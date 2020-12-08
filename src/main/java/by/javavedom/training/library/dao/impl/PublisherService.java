package by.javavedom.training.library.dao.impl;

import by.javavedom.training.library.dao.PublisherDao;
import by.javavedom.training.library.domain.Publisher;
import by.javavedom.training.library.spring.repository.PublisherRepository;
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
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }



    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
    }

    @Override
    public Page<Publisher> searh(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findAll(new PageRequest(pageNumber, pageSize, new Page(sortDirection, sortField)),searchString[0]);
    }


    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }


    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher){
        publisherRepository.delete(publisher);
    }


    @Override
    public Publisher get(long id) {
        Optional<Publisher> bookmark = publisherRepository.findById(id);
        if (bookmark.isPresent()) {
            return bookmark.get();
        } else {
            return null;
        }
    }




}

