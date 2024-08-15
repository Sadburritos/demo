package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class GreetingController {
	private final UsersRepository usersRepository;

	public GreetingController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = usersRepository.findAll();
		return ResponseEntity.ok(users);
	}

	@PostMapping("/users")
	public ResponseEntity<Users> createNewUser(@RequestBody Users users) {
		Users savedUsers = usersRepository.save(users);

		return ResponseEntity.ok(savedUsers);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable Integer id) {
		Optional<Users> findedUsers = usersRepository.findById(id);

		if (findedUsers.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(findedUsers);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Users> UpdateUserById(@PathVariable Integer id, Users users) {
		Optional<Users> findedUsers = usersRepository.findById(id);

		Users savedUsers = usersRepository.save(users);

		if (findedUsers.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(savedUsers);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Integer id, Users users) {

		usersRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

}
