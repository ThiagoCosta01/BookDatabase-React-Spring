package br.com.books.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.books.database.dto.AuthenticationDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user/login")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String login() {
		return "Olá";
	}
	
	@PostMapping
	public ResponseEntity login(@RequestBody @Valid AuthenticationDto data) {
		try {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.userName(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		return ResponseEntity.ok("Autenticado");
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação: " + e.getMessage());
		}
		
	}
	
}
