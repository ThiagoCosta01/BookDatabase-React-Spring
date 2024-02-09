package br.com.books.database.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@GetMapping
	String getBooks() {
		return "LIVROS";
	}

}
