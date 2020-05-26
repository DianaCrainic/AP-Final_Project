package com.project.services;

import com.project.dto.BookDto;
import com.project.entities.Book;
import com.project.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<BookDto> getAllBooks() {
        return ((List<Book>) bookRepository.findAll())
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    private boolean checkIfGameExists(Integer id) {
        Optional<Book>book = bookRepository.findById(id);
        return book.isPresent();
    }

    public void addBook(BookDto bookDto) {
        bookRepository.save(modelMapper.map(bookDto, Book.class));
    }
}
