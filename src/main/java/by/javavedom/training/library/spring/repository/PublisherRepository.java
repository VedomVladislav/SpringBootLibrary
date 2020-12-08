package by.javavedom.training.library.spring.repository;

import by.javavedom.training.library.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String name);

}
