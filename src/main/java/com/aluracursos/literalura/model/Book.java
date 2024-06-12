package com.aluracursos.literalura.model;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return """
                ----- BOOK -----
                Title: %s
                Author: %s
                Language: %s
                Download count: %d
                """.formatted(getTitle(),author.getName(),getLanguage(),getDownloadCount());
    }
}
