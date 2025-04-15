package com.example.Bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bookstore.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
