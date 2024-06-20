package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.controller.Controller;
import com.aluracursos.literalura.model.Author;
import com.aluracursos.literalura.model.Book;
import com.aluracursos.literalura.model.BookDTO;
import com.aluracursos.literalura.repository.Repository;
import com.aluracursos.literalura.util.Input;
import com.aluracursos.literalura.util.UserMessages;

import javax.naming.NameNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                    System.out.println(UserMessages.invalidOption());
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

    private int getSaveOption() {
        System.out.println(UserMessages.saveOption());
        int option= Input.enterValidInput(reader);
        System.out.println(UserMessages.returnOption(option));
        reader.nextLine();
        return option;
    }

    private BookDTO getBookDTO() {
        System.out.println(UserMessages.searchBook());
        String bookTitle = reader.nextLine();
        BookDTO bookDTO;
        try {
            bookDTO = controller.searchBook(bookTitle);
            return bookDTO;
        } catch (NameNotFoundException e) {
            System.out.println(UserMessages.notFoundMessage(bookTitle));
            return null;
        }
    }

    private void saveNewBook (Author author, Book newBook) {
        List<Book> oldBooks = repository.searchBooksFromAuthors(author.getName());
        List<Book> bookList = new ArrayList<>(oldBooks);
        bookList.add(newBook);
        author.setBookList(bookList);
        repository.save(author);
        System.out.println(UserMessages.savedMessage());
    }

    private void saveNewAuthor (Author author, Book newBook) {
        List<Book>  bookList = new ArrayList<>();
        bookList.add(newBook);
        author.setBookList(bookList);
        repository.save(author);
        System.out.println(UserMessages.savedMessage());
    }

    private void searchBookByTitle(){
        BookDTO newBookDTO = getBookDTO();
        if (newBookDTO == null){
            return;
        }
        Book newBook = controller.getBook(newBookDTO);
        System.out.println(newBook);
        boolean retry= true;
        while (retry){
            int option = getSaveOption();
            switch (option){
                case 1:
                    Author author = newBookDTO.auth().stream().map(Author::new).toList().get(0);
                    Optional<Author> authorQuery= repository.findByName(author.getName());
                    if (authorQuery.isEmpty()){
                        saveNewAuthor(author,newBook);
                        return;
                    }
                    Optional<Book> bookQuery = repository.searchBook(newBook.getTitle(), author.getName());
                    if (bookQuery.isEmpty()){
                        author= authorQuery.get();
                        saveNewBook(author,newBook);
                    }else {
                        System.out.println(UserMessages.alreadyExistsMessage());
                    }
                    return;
                case 2:
                    retry=false;
                    break;
                default:
                    System.out.println(UserMessages.invalidOption());
                    break;
            }
        }
    }

    private void listSearchedBooks () {
        List<Book> books= repository.searchAllBooks();
        books.forEach(l -> System.out.printf("""
                ----- BOOK -----
                Title: %s
                Author: %s
                Language: %s
                Download count: %d
                %n""", l.getTitle(),l.getAuthor().getName(),l.getLanguage(),l.getDownloadCount()));
    }

    private void listAuthors () {
        List<Author> authors= repository.findAll();
        authors.forEach(a -> System.out.printf("""
                ----- Author -----
                Name: %s
                Birth year: %d
                Death year: %d
                Books: %s
                """.formatted(a.getName(),a.getBirth_year(),a.getDeath_year(),a.getBookList().stream()
                .map(Book::getTitle).collect(Collectors.toList()))));
    }

    private void listAuthorAlive() {

    }

    private void listBooksByLang() {

    }


}
