package com.project.entities;

import lombok.*;
import javax.persistence.*;

/**
 * Library entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer budget;

}
