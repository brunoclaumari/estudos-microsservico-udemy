package com.microsservicos.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservicos.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
