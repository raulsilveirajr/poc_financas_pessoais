package com.rjr.myfinances.services;

import com.rjr.myfinances.model.entity.User;

public interface UserService {
	User authenticate(String email, String password);
	User saveUser(User user);
	void validateEmail(String email);
}
