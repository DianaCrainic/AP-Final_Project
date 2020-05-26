package com.project.entities;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    //@OneToMany(mappedBy = "book")
    //@JoinColumn(name = "author")
    //private Author author;

//    @ManyToOne
//    @JoinColumn(name = "library")
//    private Library library;
}
