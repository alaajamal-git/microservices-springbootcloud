package com.example.demo.ui.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.ui.exceptions.messages.MyCustomErrorMessage;
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {NullPointerException.class,MyOwnException.class})
	public ResponseEntity<Object> handlNullPointerException(Exception ex,WebRequest req){
		MyCustomErrorMessage error=new MyCustomErrorMessage();
		error.setEx_time(new Date());
		error.setMessage(ex.toString());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handlAnyException(Exception ex,WebRequest req){
		MyCustomErrorMessage error=new MyCustomErrorMessage();
		error.setEx_time(new Date());
		error.setMessage(ex.toString());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/**
	@ExceptionHandler(value = {MyOwnException.class})
	public ResponseEntity<Object> handlmyException(MyOwnException ex,WebRequest req){
		MyCustomErrorMessage error=new MyCustomErrorMessage();
		error.setEx_time(new Date());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/

}
