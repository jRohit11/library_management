package com.project.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id",updatable = false,nullable = false,columnDefinition = "VARCHAR(36)")
    private UUID studentId;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(nullable = false)
    private String contact;
    private String branch;
    private String accountStatus = "ACTIVE";
    private Long registrationTimeStamp=System.currentTimeMillis();

    @Column(nullable = false)
    private Long updateTimeStamp=System.currentTimeMillis();

    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "allocatedTo",cascade = CascadeType.ALL)
    private List<BookAllocation> allocatedBooks;
}
