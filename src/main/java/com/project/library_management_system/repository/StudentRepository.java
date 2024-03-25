package com.project.library_management_system.repository;

import com.project.library_management_system.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
