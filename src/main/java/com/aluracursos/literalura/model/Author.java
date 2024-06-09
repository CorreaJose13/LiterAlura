package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int birth_year;
    private int death_year;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> bookList;

    public Author(){}

    public Author(AuthorDTO author){
        this.name= author.name();
        this.birth_year= author.birthYear();
        this.death_year= author.deathYear();
    }

    public String getName() {
        return name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }
}
