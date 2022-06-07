package com.example.exception2.advice;

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
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.exception2.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("예외 발생");
		System.out.println("======================");
		System.out.println(e.getClass());
		System.out.println("======================");
		System.err.println(e.getMessage());
		System.out.println("======================");
		System.out.println(e.getCause());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
		
	}
	// GET 방식일때 파라미터 없을 경우 발생
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println(e.getMessage());
		System.out.println("MissingServletRequestParameterException 예외처리!!!!!!!!");
		
		String fieldName = e.getParameterName();
		
		System.out.println("fieldName : " + fieldName);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + " 을 입력해야 합니다.");
		
	} 
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException (MethodArgumentNotValidException e) {
		System.out.println("MethodArgumentNotValidException 예외 발생");
		
		// 한번에 전부 들어온다.
		List<CustomError> errorList = new ArrayList<>();
		
		BindingResult bindingResult = e.getBindingResult();
		
		bindingResult.getAllErrors().forEach(action -> {
			// action
			FieldError field = (FieldError)action;
			
			String fieldName = field.getField();
			String fieldMessage = field.getDefaultMessage();
			
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setField(fieldMessage);
			
			errorList.add(customError);
			
//			System.out.println("action : " + action.toString());
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException (ConstraintViolationException e) {
		// 동시에 확인 validation
		System.out.println("ConstraintViolationException 예외 발생 !!!!!!!!!!");
		List<CustomError> errorList = new ArrayList<CustomError>();
		
		e.getConstraintViolations().forEach(error -> {
							
			String strfield = error.getPropertyPath().toString();
			int index = strfield.indexOf(".");
			
			String fieldName = strfield.substring(index + 1);
			String message = error.getMessage();
			
			CustomError customError = new CustomError();
			
			customError.setField(fieldName);
			customError.setMessage(message);
			
			errorList.add(customError);
			
//			System.out.println(strfield);
			
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> methodArgumentTypeMismatchException (MethodArgumentTypeMismatchException e) {
		System.out.println("MethodArgumentTypeMismatchException catch");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(""); 
	}
	
}
