package com.project.services;

import com.project.algorithm.BestBooksForLibraryAlgorithm;
import com.project.dto.BookDto;
import com.project.dto.LibraryDto;
import com.project.entities.Author;
import com.project.entities.Book;
import com.project.entities.Library;
import com.project.exceptions.EntityNotFoundException;
import com.project.repositories.AuthorRepository;
import com.project.repositories.LibraryRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Library Service
 */
@Log4j2
@Service
public class LibraryService {
    private LibraryRepository libraryRepository;
    private AuthorRepository authorRepository;

    public LibraryService(LibraryRepository libraryRepository, AuthorRepository authorRepository) {
        this.libraryRepository = libraryRepository;
        this.authorRepository = authorRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();

    public List<LibraryDto> getAllLibraries() {
        return ((List<Library>) libraryRepository.findAll())
                .stream()
                .map(library -> modelMapper.map(library, LibraryDto.class))
                .collect(Collectors.toList());
    }

    public void addLibrary(LibraryDto libraryDto) {
        if (libraryDto.getId() != null && checkIfLibraryExists(libraryDto.getId())) {
            log.error("Library with id " + libraryDto.getId() + " already exists");
        }
        libraryRepository.save(modelMapper.map(libraryDto, Library.class));
    }

    public boolean checkIfLibraryExists(Integer id) {
        Optional<Library> library = libraryRepository.findById(id);
        return library.isPresent();
    }

    public void updateLibraryName(Integer id, String name) {
        if (!checkIfLibraryExists(id)) {
            log.error("Library with id " + id + " not found");
        }
        libraryRepository.updateName(id, name);
    }

    public void deleteLibrary(Integer id) {
        if (!checkIfLibraryExists(id)) {
            log.error("Library with id " + id + " not found");
        }
        libraryRepository.deleteById(id);
    }

    public List<BookDto> getAffordableBooksByAuthor(Integer libraryId, Integer authorId) {

        Library library = libraryRepository.findById(libraryId).orElseThrow(() -> new EntityNotFoundException("Library", libraryId));

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("Author", authorId));
        List<Book> bookByThisAuthor = author.getBooks();

        BestBooksForLibraryAlgorithm dp = new BestBooksForLibraryAlgorithm();

        return dp.solve(library, bookByThisAuthor)
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());

    }
}
