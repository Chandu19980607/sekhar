package com.kishore.sekhar.dtoDesignPattern22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
	@Autowired
	PostServiceImpl postservice;

	
	@PostMapping("savepost")
	public ResponseEntity<Postdto>savePost(@RequestBody Postdto postdto){
		  Postdto postsave =postservice.savePostdtoobject(postdto);
		return new ResponseEntity<Postdto>(postsave,HttpStatus.CREATED);
		
		
	}
}
