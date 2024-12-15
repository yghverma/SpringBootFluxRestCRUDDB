package com.reactor.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactor.app.entity.Book;
import com.reactor.app.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Mono<Book> create(Book book) {
	Mono<Book> createdBook  = bookRepository.save(book);
	return createdBook;
    }

    @Override
    public Flux<Book> getBooks() {
	return bookRepository.findAll();
    }

    @Override
    public Mono<Book> getBook(int bookId) {
	return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> updateBook(Book book, int bookId) {
	Mono<Book> oldBook = bookRepository.findById(bookId);
	return oldBook.flatMap(book1 ->{
	   book1.setAuthor(book.getAuthor());
	   book1.setDescription(book.getDescription());
	   book1.setName(book.getName());
	   book1.setPages(book.getPages());
	   book1.setPrice(book.getPrice());
	   return bookRepository.save(book1);
	});
    }

    @Override
    public Mono<Void> delete(int bookId) {
	return bookRepository.findById(bookId).flatMap(bookToDelete -> bookRepository.delete(bookToDelete));
    }

    @Override
    public Flux<Book> search(String query) {
	// TODO Auto-generated method stub
	return null;
    }

}
