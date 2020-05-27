package com.project.services;

import com.project.dto.AuthorDto;
import com.project.entities.Author;
import com.project.repositories.AuthorRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<AuthorDto> getAllAuthors() {
        return ((List<Author>) authorRepository.findAll())
                .stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    public void addAuthor(AuthorDto authorDto) {
        if (authorDto.getId() != null && checkIfAuthorExists(authorDto.getId())) {
            log.error("Author with id " + authorDto.getId() + " already exists");
        }
        authorRepository.save(modelMapper.map(authorDto, Author.class));
    }

    private boolean checkIfAuthorExists(Integer id) {
        Optional<Author> Author = authorRepository.findById(id);
        return Author.isPresent();
    }

    public void updateAuthorName(Integer id, String name) {
        if (!checkIfAuthorExists(id)) {
            log.error("Author with id " + id + " not found");
        }
        authorRepository.updateName(id, name);
    }

    public void deleteAuthor(Integer id) {
        if (!checkIfAuthorExists(id)) {
            log.error("Author with id " + id + " not found");
        }
        authorRepository.deleteById(id);
    }
}