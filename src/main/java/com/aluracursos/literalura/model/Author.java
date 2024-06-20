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
    private int birthYear;
    private int deathYear;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> bookList;

    public Author(){}

    public Author(AuthorDTO author){
        this.name= author.name();
        this.birthYear = author.birthYear();
        this.deathYear = author.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        bookList.forEach(e -> e.setAuthor(this));
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return """
                ----- Author -----
                Name: %s
                Birth year: %d
                Death year: %d
                """.formatted(getName(), getBirthYear(), getDeathYear());
    }
}
