package com.project.services;

import com.project.dto.LibraryDto;
import com.project.entities.Library;
import com.project.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
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


}
