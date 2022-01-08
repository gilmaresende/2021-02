package com.condelar.workshopmongodb.resoucer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.condelar.workshopmongodb.domain.User;
import com.condelar.workshopmongodb.dtl.UserDTO;
import com.condelar.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResoucer {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> listDto = service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserDTO> finfById(@PathVariable String id) {
		User obj = service.findById(id);
		UserDTO tdo = new UserDTO(obj);
		return ResponseEntity.ok().body(tdo);
	}
	

}
