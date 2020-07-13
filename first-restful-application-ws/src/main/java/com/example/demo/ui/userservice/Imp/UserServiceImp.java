package com.example.demo.ui.userservice.Imp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ui.models.UserRequestRest;
import com.example.demo.ui.models.UserResponseRest;
import com.example.demo.ui.shared.Utils;
import com.example.demo.ui.userservice.UserService;

@Service
public class UserServiceImp implements UserService{

	Map<String, UserRequestRest> map=new HashMap<>();
	Utils utils;
	public UserServiceImp() {

	}
	@Autowired
	public UserServiceImp(Utils utils) {
		this.utils=utils;
	}
	
	@Override
	public UserResponseRest createUser(UserRequestRest user) {

		UserResponseRest userRest =new UserResponseRest();
		String id =utils.generateUserId();
		userRest.setId(id);
		userRest.setEmail(user.getEmail());
		userRest.setFirst_name(user.getFirst_name());
		userRest.setLast_name(user.getLast_name());
		map.put(id, user);

		return userRest;
	}
	
	

}
