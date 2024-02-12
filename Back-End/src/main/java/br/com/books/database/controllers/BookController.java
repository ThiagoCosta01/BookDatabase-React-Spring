package br.com.books.database.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Operation(description = "Retorna a lista de livros do usuário no banco de dados(método não implementado)")
	@GetMapping
	String getBooks() {
		return String.format("""
				<h1> LIVROS </h1>
				lista
				
				""");
	}

}
