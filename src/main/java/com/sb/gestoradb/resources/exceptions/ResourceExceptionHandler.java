package com.sb.gestoradb.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sb.gestoradb.service.exceptions.DataIntegrityViolationException;
import com.sb.gestoradb.service.exceptions.ObjectNotFoundException;

//Manipulador de exceção dos recursos
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		
		StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
		
		StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
