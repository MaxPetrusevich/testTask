package com.test.task.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private String surname;
    @EqualsAndHashCode.Exclude
    private Integer age;
    @EqualsAndHashCode.Exclude
    private String country;
    @EqualsAndHashCode.Exclude
    private Integer booksCount;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<BookDto> bookList;
}
