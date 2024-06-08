package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToOne
    private Author author;
    private String language;
    private int downloadCount;

    public Book(){}

    public Book(BookDTO book){
        this.title=book.title();
        this.author=book.auth().stream().map(Author::new).toList().get(0);
        this.language=book.lang().get(0);
        this.downloadCount= book.download();
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return """
                ----- BOOK FOUND -----
                Title: %s
                Author: %s
                Language: %s
                Download count: %d
                """.formatted(getTitle(),author.getName(),getLanguage(),getDownloadCount());
    }
}
