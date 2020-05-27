package com.project.services;

import com.project.dto.AuthorDto;
import com.project.dto.BookDto;
import com.project.entities.Author;
import com.project.entities.Book;
import com.project.exceptions.EntityNotFoundException;
import com.project.repositories.AuthorRepository;
import com.project.repositories.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<BookDto> getAllBooks() {
        return ((List<Book>) bookRepository.findAll())
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    private boolean checkIfBookExists(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.isPresent();
    }

    private boolean checkIfAuthorExists(Integer id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.isPresent();
    }

    public void addBookToAuthor(Integer bookId, Integer authorId){
        if(bookId != null && !checkIfBookExists(bookId)){
            log.error("Book with id " + bookId + " not found");
        }
        if (authorId != null && !checkIfAuthorExists(authorId)){
            log.error("Author with id " + authorId + " not found");
        }

        Book book = bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("Book", bookId));
        Author author = authorRepository.findById(authorId).orElseThrow(()->new EntityNotFoundException("Author", authorId));

        book.getAuthor().add(author);
        bookRepository.save(modelMapper.map(book, Book.class));


    }


    public void addBook(BookDto bookDto) {
        bookRepository.save(modelMapper.map(bookDto, Book.class));
    }

//    public void updateBookName(Integer id, String name) {
//        if (!checkIfBookExists(id)) {
//            System.out.println("Book with id " + id + " not found");
//        }
//        bookRepository.updateName(id, name);
//    }

    public void deleteBook(Integer id) {
        if (!checkIfBookExists(id)) {
            log.error("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }


}
