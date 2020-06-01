package com.project.controllers;

import com.project.dto.AuthorDto;
import com.project.dto.BookDto;
import com.project.entities.Book;
import com.project.services.AuthorService;
import com.project.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Book Controller
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ApiOperation(value = "Retrieve all books",
            response = BookDto.class,
            responseContainer = "List")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}/authors")
    @ApiOperation(value = "Retrieve all authors of a specified book",
            response = AuthorDto.class,
            responseContainer = "List")
    public List<AuthorDto> getAuthorsForBook(@RequestParam Integer bookId) {
        return bookService.getAuthorsForBook(bookId);
    }

    @PostMapping
    @ApiOperation(value = "Add a new book")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return new ResponseEntity<>("Book created", HttpStatus.CREATED);
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    @ApiOperation(value = "Add an author to the book")
    public ResponseEntity<String> addBookToAuthor(@PathVariable Integer bookId, @PathVariable Integer authorId){
        bookService.addBookToAuthor(bookId, authorId);
        return new ResponseEntity<>("The author was added to the book", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update an existing book title")
    public ResponseEntity<String> updateBookTitle(@PathVariable Integer id, @RequestParam String title) {
        bookService.updateBookTitle(id, title);
        return new ResponseEntity<>("Book updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a book")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

}

