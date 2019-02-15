package com.example.jpaweb;

import com.example.jpaweb.entity.Functionality;
import com.example.jpaweb.entity.Role;
import com.example.jpaweb.entity.User;
import com.example.jpaweb.entity.enumeration.StatusRole;
import com.example.jpaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Functionality functionality = new Functionality("Add");
		Functionality functionality2 = new Functionality("Delete");
		
		Role role = new Role("Admin", StatusRole.ATIVO, Arrays.asList(functionality2));
		Role role2 = new Role("Aluno", StatusRole.ATIVO, Arrays.asList(functionality));
		
		User user = new User("Administrador", "admin@aphnet.com.br", Arrays.asList(role));
		User user2 = new User("Jo\u00e3o", "joao@aphnet.com.br", Arrays.asList(role2));
		
		userRepository.save(user);
		userRepository.save(user2);
		
		User u = userRepository.findByName("oã");
		
		System.out.println(u.getName());
	}
}
