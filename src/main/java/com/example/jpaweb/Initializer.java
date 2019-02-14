package com.example.jpaweb;

import com.example.jpaweb.entity.Role;
import com.example.jpaweb.entity.User;
import com.example.jpaweb.repository.RoleRepository;
import com.example.jpaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Role> roles = roleRepository.findAll();
		List<User> users = userRepository.findAll();
		
		Role role = new Role("Admin");
		Role role2 = new Role("Aluno");
		role = roleRepository.save(role);
		role2 = roleRepository.save(role2);
		
		User user = new User();
		user.setName("Eduardo");
		user.setEmail("eduardo@aphnet.com.br");
		user.setRole(role);
		userRepository.save(user);
		
		User user2 = new User();
		user2.setName("Gabriel");
		user2.setEmail("gabriel@aphnet.com.br");
		user2.setRole(role2);
		userRepository.save(user2);
	}
}
