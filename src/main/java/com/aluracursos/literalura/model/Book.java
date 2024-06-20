package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String language;
    private int downloadCount;
    @Transient
    private String authorName;
    @ManyToOne
    private Author author;

    public Book(){}

    public Book(BookDTO book){
        this.title=book.title();
        this.authorName= book.auth().stream().limit(1).map(AuthorDTO::name).collect(Collectors.joining());
        this.language=book.lang().get(0);
        this.downloadCount= book.download();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return """
                ----- BOOK -----
                Title: %s
                Author: %s
                Language: %s
                Download count: %d
                """.formatted(getTitle(),getAuthorName(),getLanguage(),getDownloadCount());
    }
}
