package com.aluracursos.literalura.util;

public class UserMessages {
    public static String menuString (){
        return """
                -----------------------------
                
                --- Challenge LiterAlura ----
                
                Welcome to this book catalog!!
                
                """;
    }

    public static String optionString (){
        return """
                -----------------------------
                
                Here's a list of the options available:
                
                 1. Search book by title
                 2. List searched books
                 3. List authors of searched books
                 4. List authors alive in a given year
                 5. List books by language
                 0. Exit program
                
                -----------------------------
                
                """;
    }

    public static String returnOption (int option){
        return "You've selected option "+option;
    }

    public static String searchBook () { return "Type the name of the book you wanna search:";}

    public static String listBooks () { return "Here's a list of searched books:";}

    public static String listAuthors () { return "Here's a list of authors:";}

    public static String listAuthorsAlive (int year) { return "Here's a list of authors alive at " + year + ":";}

    public static String listBookByLang (String lang) { return "Here's a list of books in " + lang + ":";}

    public static String goodByeMessage (){
        return "Thanks for using my service, see you soon!";
    }

    public static String notFoundMessage (String bookName) {return "Sorry! Your book called "+ bookName +" was not found.";}
}
