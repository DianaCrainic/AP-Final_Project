package com.project.dto;

import com.project.entities.Author;
import com.project.entities.Library;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {

    private Integer id;
    private String title;
    //private AuthorDto author;
    //private LibraryDto library;
}
