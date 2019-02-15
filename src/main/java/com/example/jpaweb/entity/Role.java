package com.example.jpaweb.entity;

import com.example.jpaweb.entity.enumeration.StatusRole;

import javax.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@Enumerated(value = EnumType.STRING)
	private StatusRole status;
	
	public Role() {
	}
	
	public Role(String name) {
		this.name = name;
		status = StatusRole.ATIVO;
	}
	
	public Role(String name, StatusRole status) {
		this.name = name;
		this.status = status;
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
}
