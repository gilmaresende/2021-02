package com.condelar.workshopmongodb.resoucer;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.condelar.workshopmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResoucer {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		User maria = new User("1", "Maria Brow", "m.gmail");
		User alex = new User("2", "Alex Green", "a.gmail");
		return ResponseEntity.ok().body(Arrays.asList(maria, alex));

	}

}
