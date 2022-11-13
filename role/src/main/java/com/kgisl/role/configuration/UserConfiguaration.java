package com.kgisl.role.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kgisl.role.model.Role;
import com.kgisl.role.model.User;
import com.kgisl.role.repository.UserRepository;

@Configuration
public class UserConfiguaration {
	
	private UserRepository userRepository;

	public UserConfiguaration(UserRepository userRepository) {
	this.userRepository = userRepository;
	}
	
	@Bean
	public  CommandLineRunner initializeDatabase() {
		return args->{
			User user1 =new User("admin","123",Role.ADMIN);
			User user2 =new User("admin2","123",Role.ADMIN);
			User user3 =new User("user","345",Role.USER);
			
			userRepository.saveAll(List.of((user1, user2, user3)));
		
			
			System.out.println("Sample database initialized");
		};
	}
    
}
