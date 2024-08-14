package com.example.demo.controler;

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

	public Iterable<Users> getAllUsers() {

		return usersRepository.findAll();
	}

	@PostMapping("/users")
	public String createNewUser(@RequestBody String entity) {
		// Тут должно быть создание пользователя в репозитории
		return "createNewUser";
	}

	@GetMapping("/users/{id}")
	public String getUserById0(@PathVariable String id) {
		// Тут должно быть получение по id из репозитория

		return "123";
	}

	@PutMapping("/users/{id}")
	public String UpdateUserById(@PathVariable String id, @RequestBody String entity) {
		// Тут получаешь по id . Если есть то сохраняешь(апдейт).
		return "123";
	}

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable String id) {
		// Тут удаляешь из репозитория
		return "123";
	}

}
