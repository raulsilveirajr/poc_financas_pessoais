package com.rjr.myfinances.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rjr.myfinances.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
