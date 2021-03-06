package by.javavedom.training.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDao<T> {

    List<T> getAll();
    T get(long id);
    T save(T obj);
    void delete(T object);

    //����� ���� �������
    List<T> search(String ... searchString);

    List<T> getAll(Sort sort);

    //��������� ������� � ���������������
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    //����� ������� � ���������������
    Page<T> searh(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String ... searchString);

}
