package com.project.controllers;

import com.project.dto.LibraryDto;
import com.project.services.LibraryService;
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

    @PostMapping
    public ResponseEntity<String> addLibrary(@RequestBody LibraryDto libraryDto) {
        libraryService.addLibrary(libraryDto);
        return new ResponseEntity<>("Library created", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteLibrary(@PathVariable Integer id) {
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>("Library created", HttpStatus.OK);
    }
}
