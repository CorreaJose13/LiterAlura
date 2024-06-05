package com.aluracursos.literalura;

import com.aluracursos.literalura.service.ApiConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var request = new ApiConsumer();
		String body = request.responseBody(request.getResponse("https://gutendex.com/books/"));
		System.out.println(body);
	}
}
