package com.example.demo.controler;



import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

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

	public Iterable<User> getAllUsers() {
	

		return usersRepository.findAll();
	}
	

	@PostMapping("/users")
	public String createNewUser(@RequestBody String entity) {
		return "createNewUser";
	}

	@GetMapping("/users/{id}")
	public String getUserById0(@PathVariable String id) {
		Users Bob = new Users("Bob", "123", "bob@gmail.com", 1);

		return Bob.toString();
	}

	@PutMapping("/users/{id}")
	public String UpdateUserById(@PathVariable String id, @RequestBody String entity) {
		return "UpdateUserById";
	}

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable String id) {
		return "deleteUserById";
	}

}

