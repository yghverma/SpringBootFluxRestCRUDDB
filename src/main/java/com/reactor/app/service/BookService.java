package com.reactor.app.service;

import com.reactor.app.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    //create a Book
    public Mono<Book> create(Book book);
    
    // Get All books
    public Flux<Book> getBooks();
    
    // Get single books
    public Mono<Book> getBook(int bookId);
    
    // Get update books
    public Mono<Book> updateBook(Book book, int bookId);
    
    // Get delete books
    public Mono<Void> delete(int bookId);
    
    // search books based on query
    public Flux<Book> search(String query);
}