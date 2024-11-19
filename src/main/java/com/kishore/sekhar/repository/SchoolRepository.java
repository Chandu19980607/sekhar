package com.kishore.sekhar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kishore.sekhar.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

 	public School findById(int id);
	
	 List<School>findByIdIn(List<Integer>id);
	 
	 School findSchoolByIdAndName(Long id, String name);
	  
	 List<School>findByVillageIsNull();
	 
	 List<School>findByVillage(String myvillage);
	 
	 List<School>findByVillageIn(List<String>ourvillage);
	 
	 @Query("SELECT DISTINCT s.village From School s")
	 List<String> findUniqueVillage();

	 @Query("SELECT DISTINCT s.strength From School s")
	 List<Integer> findAllUniqueStrength();
	 
	 
	 //======================Filters Start===========================================
	 
	 List<School>findByVillageStartingWith(String input);
	 
	 List<School>findByVillageEndingWith(String input);
	 
	 List<School>findByVillageContaining(String input);
	 
	 List<School>findByVillageEquals(String input);
	 
	 List<School>findByVillageLike(String input);
	 
	 //=======================Filter End================================================
	 
	 
	
}
