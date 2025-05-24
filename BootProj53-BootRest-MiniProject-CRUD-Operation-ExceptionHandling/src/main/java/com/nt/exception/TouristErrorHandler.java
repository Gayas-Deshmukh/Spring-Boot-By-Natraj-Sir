package com.nt.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.model.ErrorDetails;

@RestControllerAdvice
public class TouristErrorHandler 
{
	@ExceptionHandler(TouristNotFoundExeption.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundExeption ex)
	{
		System.out.println("TouristErrorHandler.handleTouristNotFound()");
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), "failed");
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception ex)
	{
		System.out.println("TouristErrorHandler.handleAllException()");
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), "failed");
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
