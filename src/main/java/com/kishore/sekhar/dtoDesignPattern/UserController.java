package com.kishore.sekhar.dtoDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userDto")
public class UserController {
	@Autowired
	UserSerivce userService;
	
	@PostMapping("saveUserLocationDetails")
	public ResponseEntity<UserLocationDto>saveUserLocationDetails(@RequestBody UserLocationDto request){
		    UserLocationDto dto  =  userService.saveUserLocationDetails(request);
		    return new ResponseEntity<UserLocationDto>(dto,HttpStatus.OK);
	}
	
	
	@PutMapping("updateUserDto")
	public ResponseEntity<UserLocationDto>updateUserLocationDto(@RequestBody UserLocationDto request){
	          UserLocationDto dto  = userService.saveUserLocationDetails(request);
		return new ResponseEntity<UserLocationDto>(dto,HttpStatus.OK);
		
	}

}
