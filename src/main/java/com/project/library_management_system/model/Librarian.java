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
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false,updatable = false,columnDefinition = "VARCHAR(36)",name = "librarian_id")
    private UUID librarianId;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(nullable = false)
    private String contact;

    @JsonIgnore
    @OneToMany(mappedBy = "issuedBy", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<BookAllocation> allocatedList;
}
