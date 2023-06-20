package com.test.task.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @NotNull
    @EqualsAndHashCode.Include
    private Long id;
    @Column
    @EqualsAndHashCode.Exclude
    private String name;
    @Column
    @EqualsAndHashCode.Exclude
    private String kind;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Author author;
    @Column
    @EqualsAndHashCode.Exclude
    private Integer pagesCount;
    @Column
    @EqualsAndHashCode.Exclude
    private Integer edition;
}
