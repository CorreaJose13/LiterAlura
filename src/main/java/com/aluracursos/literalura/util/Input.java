package com.aluracursos.literalura.util;

import java.util.Scanner;

public class Input {
    public static int enterValidInput (Scanner reader){
        int option=0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter an option:");
            if (reader.hasNextInt()) {
                option = reader.nextInt();
                validInput = true;
            } else {
                System.out.println("That's not a valid integer. Please try again.");
                reader.nextLine();
            }
        }
        return option;
    }
}
