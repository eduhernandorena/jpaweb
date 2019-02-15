package com.example.jpaweb.repository;

import com.example.jpaweb.entity.Role;
import com.example.jpaweb.entity.enumeration.StatusRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	List<Role> findByStatus(StatusRole status);
	
	Page<Role> findAll(Pageable pageable);
}
