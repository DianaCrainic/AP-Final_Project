package com.project.dto;

import lombok.*;

/**
 * Book Data Transfer Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private Integer id;
    private String title;
    private LibraryDto library;
    private Integer review;
    private Integer price;
}
