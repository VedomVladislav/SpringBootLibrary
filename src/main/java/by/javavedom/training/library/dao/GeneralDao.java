package by.javavedom.training.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDao<T> {

    List<T> getAll();
    T get(long id);
    T save(T obj);
    void delete(T object);

    //поиск всех записей
    List<T> search(String ... searchString);

    List<T> getAll(Sort sort);

    //получение записей с постраничностью
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    //поиск записей с постраничностью
    Page<T> searh(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String ... searchString);

}
