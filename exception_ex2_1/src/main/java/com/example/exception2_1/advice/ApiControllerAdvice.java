package com.example.exception2_1.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2_1.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		
		System.out.println("Exception 예외 발생!!!!!!!");
		System.out.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());		
	}
	
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e){
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		System.out.println(fieldName);
		System.out.println(fieldType);
		System.out.println(invalidValue);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + " 을 입력해야 합니다.");
	}

	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException (ConstraintViolationException e) {
		System.out.println("ConstraintViolationException catch");
		
		List<CustomError> errorList = new ArrayList<CustomError>();
		
		e.getConstraintViolations().forEach(error -> {
			String strfield = error.getPropertyPath().toString();
			int index = strfield.indexOf(".");
			
			String fieldName  = strfield.substring(index + 1);
			String message = error.getMessage();
		
			CustomError customError = new CustomError();
			
			customError.setField(fieldName);
			customError.setMessage(message);
			
			errorList.add(customError);
			
		});
		
		
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("methodArgumentNotValidException catch");
		List<CustomError> errorList = new ArrayList<>();
		
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			
			FieldError field = (FieldError) action;
			
			String fieldName = field.getField();
			String fieldMessage = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setField(fieldMessage);
			
			errorList.add(customError);
			
			
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
}
