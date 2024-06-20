package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Author, Long> {

    Optional<Author> findByName(String name);

    @Query("SELECT l FROM Author a JOIN a.bookList l WHERE a.name = :name AND l.title = :title")
    Optional<Book> searchBook(String title, String name);

    @Query("SELECT l FROM Author a JOIN a.bookList l WHERE a.name = :name")
    List<Book> searchBooksFromAuthors(String name);

    @Query("SELECT l FROM Author a JOIN a.bookList l")
    List<Book> searchAllBooks();
}
