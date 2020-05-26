package com.project.controllers;

import com.project.dto.AuthorDto;
import com.project.entities.Author;
import com.project.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
        return new ResponseEntity<>("Author created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorName(@PathVariable Integer id, @RequestParam String name) {
        authorService.updateAuthorName(id, name);
        return new ResponseEntity<>("Author updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author deleted", HttpStatus.OK);
    }
}