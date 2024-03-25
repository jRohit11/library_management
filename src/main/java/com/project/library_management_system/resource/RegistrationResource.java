package com.project.library_management_system.resource;

import com.project.library_management_system.model.Book;
import com.project.library_management_system.model.Librarian;
import com.project.library_management_system.model.Student;
import com.project.library_management_system.service.BookService;
import com.project.library_management_system.service.LibrarianService;
import com.project.library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/register")
public class RegistrationResource {
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LibrarianService librarianService;
    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
    @PostMapping("/book")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }
    @PostMapping("/librarian")
    public ResponseEntity<Object> addLibrarian(@RequestBody Librarian librarian){
        return new ResponseEntity<>(librarianService.addLibrarian(librarian),HttpStatus.CREATED);
    }
}
