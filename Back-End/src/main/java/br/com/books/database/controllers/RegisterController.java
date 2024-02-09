package br.com.books.database.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import br.com.books.database.domain.model.UserModel;
import br.com.books.database.domain.repository.UserRepository;
import br.com.books.database.dto.RegisterDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user/register")
public class RegisterController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getAllUsers() {
		System.out.println(ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll()));
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity getUserById(@PathVariable(value = "id") Long id) {

		Optional<UserModel> userModelOptional = userRepository.findById(id);
		if (userModelOptional.isPresent())
			return ResponseEntity.ok().body(userModelOptional);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado :(");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
		Optional<UserModel> userModelOptional = userRepository.findById(id);
		if (userModelOptional.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping
	public ResponseEntity registerUser(@RequestBody @Valid RegisterDto data) {
		
		var passwordHash =  passwordEncoder.encode(data.password());
				UserModel user = new UserModel(data.userName(), passwordHash);
				userRepository.save(user);
		return ResponseEntity.ok("Usuário criado");
	}
	
}
