package com.condelar.cursoS25.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.condelar.cursoS25.entities.User;
import com.condelar.cursoS25.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User finfById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		User vo = repository.getById(id);
		updateData(vo, obj);
		return repository.save(vo);
	}

	private void updateData(User vo, User obj) {
		vo.setName(obj.getName());
		vo.setEmail(obj.getEmail());
		vo.setFone(obj.getFone());
	}
}
