package com.kishore.sekhar.dtoDesignPattern22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl {
	
   @Autowired
   PostRepository postrepository;
   
//	public Postdto savePostdtoobject(Postdto postdto) {
//	       Post pos = new Post();
//	   pos.setId(postdto.getId());
//	   pos.setTitle(postdto.getTitle());
//	   pos.setContent(postdto.getContent());                   for save method
//	   pos=postrepository.save(pos);
//	       
//		return convertentitytodto(pos);
//	       
//	}
	
	public Postdto savePostdtoobject(Postdto postdto) {
//		if (postdto==null) {
//			throw new IllegalArgumentException("user dto cannot be null");
//		}
//		
		Post pos;
		if(postdto.getId()!=null) {
		  pos=	postrepository.findById(postdto.getId()).orElse(new Post());
		}
		else
		{
			pos= new Post();
		}
		

		pos.setContent(postdto.getContent());
		pos.setTitle(postdto.getTitle());
		
		pos= postrepository.save(pos);
		return convertentitytodto(pos);
		
	}
	
	public Postdto convertentitytodto(Post post) {
		Postdto dto = new Postdto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setContent(post.getContent());
		
		return dto;
		
	}

}
