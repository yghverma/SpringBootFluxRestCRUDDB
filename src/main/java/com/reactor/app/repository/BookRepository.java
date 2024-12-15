package com.reactor.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactor.app.entity.Book;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {

}