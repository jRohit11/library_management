package com.project.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false,updatable = false,columnDefinition = "VARCHAR(36)",name="book_id")
    private UUID bookId;

    @Column(nullable = false,name = "book_name")
    private String name;
    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "bookInf", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BookAllocation> allocatedTo;
}
