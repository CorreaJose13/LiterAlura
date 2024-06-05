package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BodyDTO(
        @JsonAlias("results") List<BookDTO> bookList
) {
    @Override
    public String toString() {
        return "List of books: " + bookList;
    }
}
