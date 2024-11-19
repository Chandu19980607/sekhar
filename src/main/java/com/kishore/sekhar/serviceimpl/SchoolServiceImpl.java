package com.kishore.sekhar.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kishore.sekhar.FactoryDesignPattern.ExcelFile;
import com.kishore.sekhar.model.School;
import com.kishore.sekhar.repository.SchoolRepository;
import com.kishore.sekhar.service.SchoolService;
import com.kishore.sekhar.util.SearchFilters;

@Service
public class SchoolServiceImpl implements SchoolService {
    
	@Autowired
	SchoolRepository schoolrepository;

	
	@Override
	public School saveSchool(School school) {
	 String schoolFName= school.getSchoolFName();
	 String schoolLName= school.getSchoolLName();
	 String fullname= schoolFName.concat(" "+schoolLName);
	 school.setFullname(fullname);
	return schoolrepository.save(school);
	}


	@Override
	public void deleteSchool(int id) {
		schoolrepository.deleteById(id);
		
	}


	@Override
	public School getById(int id) {
		
		return schoolrepository.findById(id);
	}


	@Override
	public List<School> listOfId(List<Integer> id) {
		
		return schoolrepository.findByIdIn(id);
	}


	@Override
	public School findSchoolByIdAndName(Long id, String name) {
		
		return schoolrepository.findSchoolByIdAndName(id, name);



	}


	@Override
	public List<School> getAll() {
		
		return schoolrepository.findAll();
	}


	@Override
	public List<School> findByVillageIsNull() {
		
		return schoolrepository.findByVillageIsNull();
	}


	@Override
	public List<School> findByVillage(String myvillage) {
		
		return schoolrepository.findByVillage(myvillage);
	}


	@Override
	public List<School> findByVillage(List<String> ourvillage) {
	
		return schoolrepository.findByVillageIn(ourvillage);
	}


	@Override
	public List<Integer> getAllUniqueStrength() {
		
		return schoolrepository.findAllUniqueStrength();
	}


	@Override
	public List<String> getAllUniqueVillage() {
		
		return schoolrepository.findUniqueVillage();
	}


	@Override
	public List<School> findSearchFilter(String filterType, String input) {
	SearchFilters filter = SearchFilters.valueOf(filterType);  // filterType is string we want to convert into enum

//	List<School>list= null;
	
	List<School>list= new ArrayList<>(); //empty list
	
	switch (filter) {
	case Startswith:
		list=schoolrepository.findByVillageStartingWith(input);
		break;
	case Endswith:
		list=schoolrepository.findByVillageEndingWith(input);
		break;
	case Contains:
		list=schoolrepository.findByVillageContaining(input);
        break;
	case Equals:
		list=schoolrepository.findByVillageEquals(input);
		break;
	case Isnull:
		list=schoolrepository.findByVillageLike(input);
		break;
	default:
		break;
	}
	
	return list;
	}

	
	

	@Override
	public boolean existUserId(Integer id) {
		
		return schoolrepository.existsById(id);
	}


	@Override
	public List<School> getAllSchools() {
		
		return schoolrepository.findAll();
	}

    private final ExcelFile excelFile = new ExcelFile();
	@Override
	public byte[] generateExcelFile() throws IOException {
		List<School>schools = schoolrepository.findAll();
		return excelFile.genFile(schools);
	}


	@Override
	public Page<School> getPaganation(Integer pagenum, Integer pagesize) {
		Pageable pageable = PageRequest.of(pagenum, pagesize);
		return schoolrepository.findAll(pageable);
	}





	
}
