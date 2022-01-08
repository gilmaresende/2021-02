package com.condelar.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.workshopmongodb.domain.User;
import com.condelar.workshopmongodb.dtl.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}
