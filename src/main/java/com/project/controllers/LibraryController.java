package com.project.controllers;

import com.project.dto.BookDto;
import com.project.dto.LibraryDto;
import com.project.services.LibraryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/libraries")
@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<LibraryDto> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{libraryId}/authors/{authorId}")
    public List<BookDto> getAffordableBooksByAuthor(@RequestParam Integer libraryId, @RequestParam Integer authorId) {
        return libraryService.getAffordableBooksByAuthor(libraryId, authorId);
    }


    @PostMapping
    public ResponseEntity<String> addLibrary(@RequestBody LibraryDto libraryDto) {
        libraryService.addLibrary(libraryDto);
        return new ResponseEntity<>("Library created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing library name")
    public ResponseEntity<String> updateLibraryName(@PathVariable Integer id, @RequestParam String name) {
        libraryService.updateLibraryName(id, name);
        return new ResponseEntity<>("Library updated", HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete a library")
    public ResponseEntity<String> deleteLibrary(@PathVariable Integer id) {
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>("Library created", HttpStatus.OK);
    }


}
