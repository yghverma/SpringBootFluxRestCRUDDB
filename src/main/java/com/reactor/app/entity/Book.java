package com.reactor.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {

    @Id
    @Column("book_id")
    private int bookId;
    private String name;
    @Column("book_desc")
    private String description;
    private String author;
    private double price;
    private int pages;
   
    public Book(int bookId, String name, String description, String author, double price, int pages) {
	super();
	this.bookId = bookId;
	this.name = name;
	this.description = description;
	this.author = author;
	this.price = price;
	this.pages = pages;
    }
    
    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}