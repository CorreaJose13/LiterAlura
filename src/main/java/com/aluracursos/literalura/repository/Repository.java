package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Author, Long> {

    @Query("SELECT l FROM Author a JOIN a.bookList l")
    List<Book> buscarTodosLosLibros();
}
