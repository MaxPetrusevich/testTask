package com.test.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.task.entities.Author;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookDto {
    @EqualsAndHashCode.Include
    private Long id;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private String kind;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private AuthorDto author;
    @EqualsAndHashCode.Exclude
    private Integer pagesCount;
    @EqualsAndHashCode.Exclude
    private Integer edition;
}
