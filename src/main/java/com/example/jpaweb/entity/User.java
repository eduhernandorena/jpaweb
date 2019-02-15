package com.example.jpaweb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Role> roles;
	
	public User() {
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public User(String name, String email, List<Role> roles) {
		this.name = name;
		this.email = email;
		this.roles = roles;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRole(List<Role> roles) {
		this.roles = roles;
	}
}
