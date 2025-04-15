package com.example.Bookstore.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bookstore.Model.Book;
import com.example.Bookstore.Repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public List<Book> getAllBooks(){
		List<Book> bookList= bookRepository.findAll();
		return bookList;
	}
	
	/**
	 * 
	 * @param bookId the id of a book
	 * @param quantity the quantity to remove to add to the stock. negativ value for decreasing and positive for increasing
	 */
	@Transactional
	public void updateStock(Long bookId, int quantity) {
		Optional<Book> bookOptional= bookRepository.findById(bookId);
		if (bookOptional.isEmpty()) {
			throw new IllegalArgumentException("Book with id: "+ bookId+" not found.");
		}
		Book book= bookOptional.get();
		book.setStock(book.getStock()+quantity);
		bookRepository.save(book);
		
	}
	
	public Book getBook(Long bookId) {
		Optional<Book> bookOptional= bookRepository.findById(bookId);
		if (bookOptional.isEmpty()) {
			throw new IllegalArgumentException("Book with id: "+bookId+" not found.");
		}
		Book book=bookOptional.get();
		return book;
	}
	
	@Transactional
	public void updateBook(Book book) {
		
		bookRepository.save(book);
	}

	public Optional<Book> findById(Long bookId) {
		Optional<Book> bookOptional= bookRepository.findById(bookId);
		
		return bookOptional;
	}
	
	
}
