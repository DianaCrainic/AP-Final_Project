package com.project.dto;

import com.project.entities.Author;
//import com.project.entities.Library;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {

    private Integer id;
    private String title;
    //private Author author;
    //private Library library;
}
