package com.project.library_management_system.repository;

import com.project.library_management_system.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, UUID> {
}
