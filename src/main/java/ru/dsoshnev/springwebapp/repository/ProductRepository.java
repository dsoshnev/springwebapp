package ru.dsoshnev.springwebapp.repository;

import ru.dsoshnev.springwebapp.model.*;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
