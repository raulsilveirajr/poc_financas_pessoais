package com.rjr.myfinances.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rjr.myfinances.exception.BusinessRuleException;
import com.rjr.myfinances.model.entity.User;
import com.rjr.myfinances.model.repository.UserRepository;
import com.rjr.myfinances.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateEmail(String email) {
		boolean existsUser = userRepository.existsByEmail(email);
		if (existsUser) {
			throw new BusinessRuleException("This e-mail address is already being used.");
		}	
	}

}
