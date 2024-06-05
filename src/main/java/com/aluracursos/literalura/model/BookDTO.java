package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorDTO> auth,
        @JsonAlias("languages") List<String> lang,
        @JsonAlias("download_count") Integer download
) {
    @Override
    public String toString() {
        String languages= String.join(",", lang);
        return "Book {" +
                "Title: " + title +
                ", Author: " + auth +
                ", Language: " + languages +
                ", Total downloads: " + download +
                '}';
    }
}