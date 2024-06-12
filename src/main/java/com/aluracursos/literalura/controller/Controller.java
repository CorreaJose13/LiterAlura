package com.aluracursos.literalura.controller;

import com.aluracursos.literalura.model.Book;
import com.aluracursos.literalura.model.responseDTO;
import com.aluracursos.literalura.model.BookDTO;
import com.aluracursos.literalura.service.ApiConsumer;
import com.aluracursos.literalura.service.OMapper;
import com.aluracursos.literalura.util.UserMessages;

import javax.naming.NameNotFoundException;

public class Controller {
    private final ApiConsumer consumer= new ApiConsumer();
    private final OMapper mapper = new OMapper();

    public BookDTO searchBook (String bookName) throws NameNotFoundException {
        String BASE_URL = "https://gutendex.com/books/?search=";
        String bookFormatted = bookName.replace(" ","+").toLowerCase();
        String url = BASE_URL+bookFormatted;
        String body = consumer.responseBody(consumer.getResponse(url));
        System.out.println(body);
        var responseDTO = mapper.convertData(body, responseDTO.class);
        if (responseDTO.count() == 0){
            throw new NameNotFoundException();
        }
        var bookList = responseDTO.bookList();
        System.out.println(bookList);
        return bookList.get(0);
    }

    public Book getBook (String bookName){
        try {
            BookDTO bookDTO = searchBook(bookName);
            var book = new Book(bookDTO);
            System.out.println(book);
            return book;
        }catch (NameNotFoundException e){
            System.out.println(UserMessages.notFoundMessage(bookName));
            return null;
        }
    }
}
