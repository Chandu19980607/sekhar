package com.kishore.sekhar.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {
   
	@ExceptionHandler(loveMarriageException.class)
		public ResponseEntity<Errors>loveMarriageException(HttpServletRequest request){
		Errors error= new Errors(new Date(), 333, "about Love", "i am not eligible", request.getRequestURI(), "love is not for me");
		return new ResponseEntity<Errors>(error,HttpStatus.BAD_REQUEST);
	}
		
	@ExceptionHandler(InsufficientFundsException.class) 
	    public ResponseEntity<Errors>InsufficientFundsException(HttpServletRequest request){
		Errors error = new Errors(new Date(), 100, "insufficient funds", "please credit your account",request.getRequestURI(),"about money");
        return new ResponseEntity<Errors>(error,HttpStatus.BAD_GATEWAY);
	}
	 
	@ExceptionHandler(Exception.class)
	   public ResponseEntity<Errors>globalException(HttpServletRequest request){
	   Errors error = new Errors(new Date(), 500, "bad request", "please check your request",request.getRequestURI(),"global exception for all");
	   return new ResponseEntity<Errors>(error,HttpStatus.BAD_REQUEST);
			
			
		
	}
	
	
}	


