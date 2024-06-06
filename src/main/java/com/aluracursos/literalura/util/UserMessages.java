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

    public static String goodByeMessage (){
        return "Thanks for using my service, see you soon!";
    }
}
