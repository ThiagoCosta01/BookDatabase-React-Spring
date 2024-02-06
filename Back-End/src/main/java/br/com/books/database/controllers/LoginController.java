package br.com.books.database.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/login")
public class LoginController {

	@GetMapping
	public String login() {
		return "Olá";
	}
	
}
