package com.kishore.sekhar.dtoDesignPattern;

import lombok.Data;

@Data
public class UserLocationDto {
	private int userId;
	private String username;
	private double latitude;
	private double longitude;
	private String placeName;

}
