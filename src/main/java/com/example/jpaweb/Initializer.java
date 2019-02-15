package com.example.jpaweb;

import com.example.jpaweb.entity.Functionality;
import com.example.jpaweb.entity.Role;
import com.example.jpaweb.entity.User;
import com.example.jpaweb.entity.enumeration.StatusRole;
import com.example.jpaweb.repository.RoleRepository;
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
		
		Role role = new Role("Admin", StatusRole.ATIVO, Arrays.asList(functionality));
		Role role3 = new Role("Aluno", StatusRole.ATIVO, Arrays.asList(functionality2));
		
		User user = new User("Administrador", "admin@aphnet.com.br", Arrays.asList(role, role3));
		
		userRepository.save(user);
		
		for (User u : userRepository.findAll()) {
			System.out.println("Usu\u00e1rio: " + u.getName());
			for (Role r : u.getRoles()) {
				System.out.println("Perfil: " + r.getName());
				for (Functionality f : r.getFunctionalities()) {
					System.out.println("Funcionalidade: " + f.getName());
				}
			}
		}
	}
}
