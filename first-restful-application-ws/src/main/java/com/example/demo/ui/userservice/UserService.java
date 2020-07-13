package com.example.demo.ui.userservice;

import com.example.demo.ui.models.UserRequestRest;
import com.example.demo.ui.models.UserResponseRest;

public interface UserService {

	
	public UserResponseRest createUser(UserRequestRest user);
	
	
}
