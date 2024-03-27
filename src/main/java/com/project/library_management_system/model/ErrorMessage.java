package com.project.library_management_system.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessage {

    private String message;
    private String status;
    private long dateTime;
}
