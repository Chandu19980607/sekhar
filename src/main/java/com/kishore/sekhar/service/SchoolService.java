package com.kishore.sekhar.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.kishore.sekhar.model.School;

public interface SchoolService {

	School saveSchool(School school);

	




	void deleteSchool(int id);






	School getById(int id);






	List<School> listOfId(List<Integer>id);






	School findSchoolByIdAndName(Long id, String name);






	List<School> getAll();






	List<School> findByVillageIsNull();






	List<School> findByVillage(String myvillage);






	List<School> findByVillage(List<String> ourvillage);






	List<Integer> getAllUniqueStrength();






	List<String> getAllUniqueVillage();






	List<School> findSearchFilter(String filterType, String input);






	boolean existUserId(Integer id);






	List<School> getAllSchools();






	byte[] generateExcelFile() throws IOException;






	Page<School> getPaganation(Integer pagenum, Integer pagesize);











	

}
