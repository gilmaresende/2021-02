package com.condelar.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.workshopmongodb.domain.User;
import com.condelar.workshopmongodb.repository.UserRepository;
import com.condelar.workshopmongodb.services.exeption.ObjectNotFondException;	

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFondException("Objeto não encontrado");
		}
		
		return user.get();
	}

}
