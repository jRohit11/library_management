package com.project.library_management_system.service;

import com.project.library_management_system.model.*;
import com.project.library_management_system.repository.BookAllocationRepository;
import com.project.library_management_system.repository.BookRepository;
import com.project.library_management_system.repository.LibrarianRepository;
import com.project.library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookAllocationService {

    @Autowired
    private BookAllocationRepository bookAllocationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    public BookAllocation allocatedBook(AllocationRequest allocationRequest){
        Optional<Student> student = studentRepository.findById(allocationRequest.getAllocateTo());
        Optional<Book> book = bookRepository.findById(allocationRequest.getBokInf());
        Optional<Librarian> librarian = librarianRepository.findById(allocationRequest.getIssuedBy());

        if(student.isPresent() && book.isPresent() && librarian.isPresent()){
            return BookAllocation.builder().allocatedTo(student.get())
                    .bookInf(book.get())
                    .issuedBy(librarian.get())
                    .issuedOnTimeStamp(System.currentTimeMillis())
                    .build();
        }else{
            return null;
        }
    }

    public BookAllocationResponse getAllocation(UUID id){
        BookAllocation bookAllocation = bookAllocationRepository.findById(id).orElse(null);
        return BookAllocationResponse.builder()
                .allocatedTo(bookAllocation.getAllocatedTo())
                .bookAllocationId(bookAllocation.getBookAllocationId())
                .bookInf(bookAllocation.getBookInf())
                .returnedStatus(bookAllocation.isReturnedStatus())
                .issuedBy(bookAllocation.getIssuedBy())
                .returnedTimeStamp(bookAllocation.getReturnedTimeStamp())
                .build();

    }
}
