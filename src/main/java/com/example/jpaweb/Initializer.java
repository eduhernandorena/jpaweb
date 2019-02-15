package com.example.jpaweb;

import com.example.jpaweb.entity.Role;
import com.example.jpaweb.entity.User;
import com.example.jpaweb.entity.enumeration.StatusRole;
import com.example.jpaweb.repository.RoleRepository;
import com.example.jpaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Role> roles = roleRepository.findAll();
		for (int i = 0; i < 1000; i++) {
			saveRole("Admin", StatusRole.ATIVO);
		}
		for (int i = 0; i < 1000; i++) {
			saveRole("iafehiuaf", StatusRole.INATIVO);
		}
		PageRequest pr = PageRequest.of(950, 60);
		Page<Role> rols = roleRepository.findAll(pr);
		
		for (Role role : rols) {
			System.out.println(role.getName());
		}
	}
	
	public void saveRole(String roleName, StatusRole status) {
		Role role = new Role(roleName, status);
		roleRepository.save(role);
	}
}
