package com.reactor.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactor.app.entity.Book;
import com.reactor.app.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    //create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
	return bookService.create(book);
    }
    
    //Get All
    @GetMapping
    public Flux<Book> getAll() {
	return bookService.getBooks();
    }

    //set single Book
    @GetMapping("/{bookId}")
    public Mono<Book> getSingleBook(@PathVariable int bookId) {
	return bookService.getBook(bookId);
    }
    
    //update book
    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@RequestBody Book book, @PathVariable int bookId) {
	return bookService.updateBook(book, bookId);
    }
    
    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBook(@PathVariable int bookId) {
	return bookService.delete(bookId);
    }
}