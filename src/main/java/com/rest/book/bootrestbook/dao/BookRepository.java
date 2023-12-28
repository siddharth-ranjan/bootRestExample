package com.rest.book.bootrestbook.dao;

import com.rest.book.bootrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);

}
