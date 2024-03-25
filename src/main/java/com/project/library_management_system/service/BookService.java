package com.project.library_management_system.service;

import com.project.library_management_system.model.Book;
import com.project.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
}
