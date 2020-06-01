package com.project.dto;

import lombok.*;

/**
 * Data Transfer Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LibraryDto {
    private Integer id;
    private String name;
    private Integer budget;
}
