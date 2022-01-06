package com.condelar.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.condelar.workshopmongodb.domain.User;
import com.condelar.workshopmongodb.repository.UserRepository;

@Configuration
public class Instancietion implements CommandLineRunner {

	@Autowired
	UserRepository userReposiroty;	
	
	@Override
	public void run(String... args) throws Exception {
		
		userReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
	}

}
