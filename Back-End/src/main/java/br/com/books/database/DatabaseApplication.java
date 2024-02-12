package br.com.books.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Books Database", version = "0.0.2", description = "API com sistema de login e gerenciamento de leitura de livros."))
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
		System.out.println("Senha (teste): ");
		System.out.println(new BCryptPasswordEncoder().encode("teste"));
	}

}
