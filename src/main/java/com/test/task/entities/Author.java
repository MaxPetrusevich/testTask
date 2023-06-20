package com.test.task.entities;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @EqualsAndHashCode.Include
    private Long id;
    @Column
    @EqualsAndHashCode.Exclude
    private String name;
    @Column
    @EqualsAndHashCode.Exclude
    private String surname;
    @Column
    @EqualsAndHashCode.Exclude
    private Integer age;
    @Column
    @EqualsAndHashCode.Exclude
    private String country;
    @Column
    @EqualsAndHashCode.Exclude
    private Integer booksCount;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private List<Book> bookList;
}
