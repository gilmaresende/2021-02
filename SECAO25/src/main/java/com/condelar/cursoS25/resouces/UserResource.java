package com.condelar.cursoS25.resouces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condelar.cursoS25.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1l, "Ana", "ana.lara@gmail.com", "999999", "123");
		return ResponseEntity.ok().body(u);
	}

}
