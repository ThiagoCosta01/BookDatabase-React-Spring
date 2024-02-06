package br.com.books.database.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.books.database.domain.user.UserDto;
import br.com.books.database.domain.user.UserModel;
import br.com.books.database.domain.user.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user/register")
public class UserController {

	@Autowired
	UserRepository userRepository;

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
	
	

}
