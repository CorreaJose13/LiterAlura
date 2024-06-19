package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.controller.Controller;
import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import com.aluracursos.literalura.repository.Repository;
import com.aluracursos.literalura.util.Input;
import com.aluracursos.literalura.util.UserMessages;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private final Scanner reader = new Scanner(System.in);
    private final Controller controller = new Controller();
    private final Repository repository;

    private boolean retry=true;

    public Principal(Repository repository){
        this.repository= repository;
    }

    public void runProgram(){
        System.out.println(UserMessages.menuString());
        while (retry){
            int option= getOption();
            switch (option){
                case 0:
                    System.out.println(UserMessages.goodByeMessage());
                    retry=false;
                    break;
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    listSearchedBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    listAuthorAlive();
                    break;
                case 5:
                    listBooksByLang();
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid value.");
                    break;
            }
        }
        reader.close();
    }

    private int getOption() {
        System.out.println(UserMessages.optionString());
        int option= Input.enterValidInput(reader);
        System.out.println(UserMessages.returnOption(option));
        reader.nextLine();
        return option;
    }

    private void searchBookByTitle(){
        System.out.println(UserMessages.searchBook());
        String bookTitle = reader.nextLine();
        Book book = controller.getBook(bookTitle);
        System.out.println(book);
        Author author = book.getAuthor();
        author.addToBookList(book);
        repository.save(author);
    }

    private void listSearchedBooks () {
        List<Book> books= repository.buscarTodosLosLibros();
        System.out.println(books);
    }

    private void listAuthors () {

    }

    private void listAuthorAlive() {

    }

    private void listBooksByLang() {

    }


}
