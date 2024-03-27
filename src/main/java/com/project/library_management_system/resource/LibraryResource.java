package com.project.library_management_system.resource;

import com.project.library_management_system.exception.InvalidRequestException;
import com.project.library_management_system.model.AllocationRequest;
import com.project.library_management_system.model.BookAllocation;
import com.project.library_management_system.model.BookAllocationResponse;
import com.project.library_management_system.service.BookAllocationService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/library")
public class LibraryResource {

    @Autowired
    private BookAllocationService bookAllocationService;
    @PostMapping("/allocation")
    public ResponseEntity<Object> allocatedBook(@RequestBody AllocationRequest allocationRequest){
        BookAllocation bookAllocation =bookAllocationService.allocatedBook(allocationRequest);
        if(bookAllocation==null){
            throw new InvalidRequestException();
        }
        return new ResponseEntity<>(bookAllocation,HttpStatus.CREATED);

        //return new ResponseEntity<>(bookAllocationService.allocatedBook(allocationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/allocation/get/{id}")
    public ResponseEntity<Object> getAllocation(@PathVariable UUID id){
        BookAllocationResponse bookAllocationResponse = bookAllocationService.getAllocation(id);
        if(bookAllocationResponse==null){
            throw new InvalidRequestException();
        }
        return new ResponseEntity<>(bookAllocationResponse,HttpStatus.FOUND);
    }
}
