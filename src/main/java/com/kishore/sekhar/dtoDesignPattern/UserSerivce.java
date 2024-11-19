package com.kishore.sekhar.dtoDesignPattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivce {
    @Autowired
	UserRepository userRepository;

	public UserLocationDto saveUserLocationDetails(UserLocationDto request) {
//		User us = new User();
//		us.setUserId(request.getUserId());
//		us.setUsername(request.getUsername());   // convert dto class to entity class 
//			
//		Location loc = new Location();
//        loc.setLatitude(request.getLatitude());
//        loc.setLongitude(request.getLongitude());
//        loc.setPlaceName(request.getPlaceName());
//        us.setLocation(loc);
        User us =convertUserLocationDtoToEntity(request);
        User response =userRepository.save(us);
     
        
        UserLocationDto dto  =convertEntitytoUserLocationDto(response);
        return dto;
	}     
     public static User convertUserLocationDtoToEntity(UserLocationDto request) {
    		User us = new User();
    		us.setUserId(request.getUserId());
    		us.setUsername(request.getUsername());   // convert dto class to entity class 
    			
    		Location loc = new Location();
            loc.setLatitude(request.getLatitude());
            loc.setLongitude(request.getLongitude());
            loc.setPlaceName(request.getPlaceName());
            
            us.setLocation(loc);
            return us;
    	 
     }
     
     public static UserLocationDto convertEntitytoUserLocationDto(User response) {
    	 
        
        UserLocationDto dto = new UserLocationDto();   //convert entity class to dto class
                        dto.setUserId(response.getUserId());
                        dto.setUsername(response.getUsername());
                        dto.setLatitude(response.getLocation().getLatitude());
                        dto.setLongitude(response.getLocation().getLongitude());
                        dto.setPlaceName(response.getLocation().getPlaceName());
        
        
        return dto;
	}
    
    
}
