package com.kishore.sekhar.model;

public class DataValidations {
	
	public static boolean NullValidation(String message) {
        return message == null || message.trim().isEmpty();
    }

}
