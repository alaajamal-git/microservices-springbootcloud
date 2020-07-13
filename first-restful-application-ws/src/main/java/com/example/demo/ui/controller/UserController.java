package com.example.demo.ui.controller;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ui.errors.ApiError;
import com.example.demo.ui.models.UserRequestRest;
import com.example.demo.ui.models.UserResponseRest;
import com.example.demo.ui.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Map<String, UserRequestRest> map=new HashMap<>();
	@Autowired
	UserService userService;
	@GetMapping
	public String getUsers(@RequestParam(value="page",defaultValue = "1") int page
			,@RequestParam(value="limits",defaultValue = "50") int limits
			,@RequestParam(value="sort_type",required = false) String sort_type) {
		
		return "pages: "+page+", limits: "+limits+", sort type: "+sort_type;
	}
	
	@GetMapping(path = "/{userID}")
	public ResponseEntity<UserRequestRest> getUser(@PathVariable String userID) {
		 
		if(map.containsKey(userID)) {
			
		UserRequestRest value=map.get(userID);;
		value.setId(userID);
		return new ResponseEntity<UserRequestRest>(value, HttpStatus.OK);
		}
		else {
			//throw new MyOwnException("my exception occurs");}// throw custom exception
			return new ResponseEntity<UserRequestRest>(HttpStatus.BAD_REQUEST);}

		
				}
	
	
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestRest user, Errors errors) {
		
		if (errors.hasErrors()) {
	        return new ResponseEntity<>(new ApiError(errors), HttpStatus.BAD_REQUEST);
	    }
		UserResponseRest response=userService.createUser(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	
	}
	
	@PutMapping(path = "/{userID}")
	public  ResponseEntity<?> updateUser(@PathVariable String userID, @RequestBody UserRequestRest user) {
		
		UserRequestRest value=map.get(userID);
		value.setFirst_name(user.getFirst_name());
		value.setLast_name(user.getLast_name());
		map.put(userID, value);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userID}")
	public ResponseEntity<?> deleteUser(@PathVariable String userID) {
		// String s=null; s.length(); //generate exception
		if(map.containsKey(userID))
		{
			map.remove(userID);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
	

}
