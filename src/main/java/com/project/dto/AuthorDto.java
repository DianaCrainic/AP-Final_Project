package com.project.dto;

import lombok.*;

/**
 * Author Data Transfer Object
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AuthorDto {
    private Integer id;
    private String name;
}
