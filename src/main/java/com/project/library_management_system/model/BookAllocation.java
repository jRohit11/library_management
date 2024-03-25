package com.project.library_management_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Getter
@Setter
@Entity
public class BookAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bookAllocation_id",nullable = false,updatable = false)
    private UUID bookAllocationId;

    @JsonBackReference
    @JoinColumn(name="student_id",updatable = false,nullable = false,columnDefinition = "VARCHAR(36)")
    @ManyToOne(optional = false)
    private Student allocatedTo;

    @JoinColumn(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "librarian_id")
    @JsonBackReference
    @ManyToOne(optional = false)
    private Librarian issuedBy;

    @JoinColumn(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)", name = "book_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Book bookInf;

    @Column(nullable = false,updatable = false,columnDefinition = "VARCHAR(36)",name = "issued_on")
    private Long issuedOnTimeStamp = System.currentTimeMillis();

    @Column(nullable = false,name = "returned_status")
    private boolean returnedStatus = false;

    @Column(columnDefinition = "VARCHAR(36)",name="returned_on")
    private Long returnedTimeStamp;
}
