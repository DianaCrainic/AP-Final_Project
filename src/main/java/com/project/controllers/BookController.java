package com.project.controllers;

import com.project.dto.AuthorDto;
import com.project.dto.BookDto;
import com.project.entities.Book;
import com.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
        return new ResponseEntity<>("Book created", HttpStatus.CREATED);
    }

    @PostMapping("/{bookId}/authors/{authorId}")
    public ResponseEntity<String> addBookToAuthor(@PathVariable Integer bookId, @PathVariable Integer authorId){
        bookService.addBookToAuthor(bookId, authorId);
        return new ResponseEntity<>("The book and the author were created", HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

}

