package com.project.library_management_system.service;

import com.project.library_management_system.model.Librarian;
import com.project.library_management_system.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;
    public Librarian addLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }
}