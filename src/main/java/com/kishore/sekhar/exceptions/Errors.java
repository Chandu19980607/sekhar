package com.kishore.sekhar.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor


public class Errors {
	
	public Date timestamp;
	public int status;
	public String error;
	public String message;
	public String path;
	public String ownmessage; 

}
