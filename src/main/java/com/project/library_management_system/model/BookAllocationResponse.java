package com.project.library_management_system.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class BookAllocationResponse {
    private UUID bookAllocationId;
    private Student allocatedTo;
    private Book bookInf;
    private Librarian issuedBy;
    private Long issuedOnTimeStamp;
    private boolean returnedStatus;
    private Long returnedTimeStamp;
}
