package com.example.demo.controller;

import java.util.List;

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
	public String createNewUser(@RequestBody String entity) {
		// Тут должно быть создание пользователя в репозитории
		// На вход должен быть User user
		return usersRepository.save();
	}

	@GetMapping("/users/{id}")
	public Long getUserById(@PathVariable Long id) {
		// Тут должно быть получение по id из репозитория
		// Возврат должен быть типа User
		return usersRepository.findById(id);
	}

	@PutMapping("/users/{id}")
	public String UpdateUserById(@PathVariable String id, @RequestBody String entity) {
		// Тут получаешь по id . Если есть то сохраняешь(апдейт).
		return "123";
	}

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable String id) {
		// Тут удаляешь из репозитория
		// Тут на возврат можно сделать void
		return usersRepository.deleteAllById(id);
	}

}
