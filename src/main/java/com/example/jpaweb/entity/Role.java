package com.example.jpaweb.entity;

import com.example.jpaweb.entity.enumeration.StatusRole;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Enumerated(value = EnumType.STRING)
	private StatusRole status;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Functionality> functionalities;
	
	public Role() {
	}
	
	public Role(String name) {
		this.name = name;
		status = StatusRole.ATIVO;
	}
	
	public Role(String name, StatusRole status, List<Functionality> functionalities) {
		this.name = name;
		this.status = status;
		this.functionalities = functionalities;
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
	
	public StatusRole getStatus() {
		return status;
	}
	
	public void setStatus(StatusRole status) {
		this.status = status;
	}
	
	public List<Functionality> getFunctionalities() {
		return functionalities;
	}
	
	public void setFunctionalities(List<Functionality> functionalities) {
		this.functionalities = functionalities;
	}
}
