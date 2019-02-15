package com.example.jpaweb.repository;

import com.example.jpaweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.name like %?1%")
	User findByName(String name);
	
	User findByEmail(String email);
}
