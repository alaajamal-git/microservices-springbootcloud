package com.example.demo.ui.errors;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ApiError {
	
	private List<ObjectError> message;
	
	public ApiError(Errors errors) {

		message=errors.getAllErrors();

	}

	public List<ObjectError> getMessage() {
		return message;
	}

	public void setMessage(List<ObjectError> message) {
		this.message = message;
	}

	
	
	
	

	
}
