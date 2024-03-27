package com.project.library_management_system.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AllocationRequest {
    private UUID allocateTo;
    private UUID bokInf;
    private UUID issuedBy;
}
