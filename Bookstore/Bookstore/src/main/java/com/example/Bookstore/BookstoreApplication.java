package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void run(String... args)  {
		 // Book definitions:
        bookRepository.save(new Book("Fellowship of the book", 5.0, 100)); // Adjust initial stock as needed
        bookRepository.save(new Book("Books and the chamber of books", 10.0, 100));
        bookRepository.save(new Book("The Return of the Book", 15.0, 100));
        // For Book D, limit stock to 10 copies
        bookRepository.save(new Book("Limited Collectors Edition", 75.0, 10));
		
	}

}
