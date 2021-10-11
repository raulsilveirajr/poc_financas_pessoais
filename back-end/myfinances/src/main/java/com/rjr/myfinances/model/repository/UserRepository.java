package com.rjr.myfinances.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rjr.myfinances.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Optional<User> findByEmail(String email);
	// Optional<User> findByEmailAndName(String email, String name);
	boolean existsByEmail(String email);
}
