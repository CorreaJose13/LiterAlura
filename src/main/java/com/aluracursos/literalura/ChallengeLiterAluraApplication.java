package com.aluracursos.literalura;

import com.aluracursos.literalura.service.ApiConsumer;
import com.aluracursos.literalura.util.Input;
import com.aluracursos.literalura.util.UserMessages;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ChallengeLiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);
		boolean retry=true;

		System.out.println(UserMessages.menuString());
		while (retry){
			System.out.println(UserMessages.optionString());
			int option= Input.enterValidInput(reader);
			System.out.println(UserMessages.returnOption(option));
			switch (option){
				case 0:
					System.out.println(UserMessages.goodByeMessage());
					retry=false;
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid option. Please enter a valid value.");
					break;
			}
		}
		reader.close();
	}
}
