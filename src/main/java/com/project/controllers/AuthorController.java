package com.project.controllers;

import com.project.dto.AuthorDto;
import com.project.services.AuthorService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Retrieve all authors",
            response = AuthorDto.class,
            responseContainer = "List")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/books/{id}")
    @ApiOperation(value = "Retrieve all authors of a specified book",
            response = AuthorDto.class,
            responseContainer = "List")
    public List<AuthorDto> getAuthorsForBook(@RequestParam Integer bookId) {
        return authorService.getAuthorsForBook(bookId);
    }

    @PostMapping
    @ApiOperation(value = "Add a new author")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        authorService.addAuthor(authorDto);
        return new ResponseEntity<>("Author created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing author name")
    public ResponseEntity<String> updateAuthorName(@PathVariable Integer id, @RequestParam String name) {
        authorService.updateAuthorName(id, name);
        return new ResponseEntity<>("Author updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an author")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>("Author deleted", HttpStatus.OK);
    }
}