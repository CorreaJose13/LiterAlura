package com.aluracursos.literalura.controller;

import com.aluracursos.literalura.model.responseDTO;
import com.aluracursos.literalura.model.BookDTO;
import com.aluracursos.literalura.service.ApiConsumer;
import com.aluracursos.literalura.service.OMapper;

import java.net.http.HttpResponse;

public class Controller {
    private final String baseURL = "https://gutendex.com/books/";
    private ApiConsumer consumer= new ApiConsumer();
    private OMapper mapper = new OMapper();

    public BookDTO searchBook (String bookName) {
        String bookFormatted = bookName.replace(" ","%20");
        HttpResponse<String> response = consumer.getResponse(baseURL+"?"+bookFormatted);
        String body = consumer.responseBody(response);
        var bodyDTO = mapper.convertData(body, responseDTO.class);
        if (bodyDTO.count() == 0){
            return null;
        }
        var bookList = bodyDTO.bookList();
        return bookList.get(0);
    }
}
