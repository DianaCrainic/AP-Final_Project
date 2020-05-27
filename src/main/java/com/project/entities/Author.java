package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "author")
    private List<Book> book = new ArrayList<>();

    public Author findById(Integer id){
        Author author = new Author();
        if (author.getId() == id){
            return author;
        }
        return null;
    }

}
