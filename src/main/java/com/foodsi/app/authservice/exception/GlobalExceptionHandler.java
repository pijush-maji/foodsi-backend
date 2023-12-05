package com.foodsi.app.authservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.foodsi.app.authservice.dto.CustomExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomExceptionResponse> UserNotFoundExceptionHandler(UserNotFoundException ex) {
		CustomExceptionResponse response = new CustomExceptionResponse(ex.getMessage(),LocalDateTime.now());
		return new ResponseEntity<CustomExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
}
