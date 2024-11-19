package com.kishore.sekhar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.sekhar.FactoryDesignPattern.FactoryDesignMain;
import com.kishore.sekhar.FactoryDesignPattern.PdfFile;
import com.kishore.sekhar.exceptions.IntergerToStringException;
import com.kishore.sekhar.model.School;
import com.kishore.sekhar.service.SchoolService;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("school")
public class SchoolController {
	@Autowired
	SchoolService schoolservice;
	
	@RequestMapping(value="saveStudent", method= RequestMethod.POST)
	public ResponseEntity<School>saveStudent(@RequestBody School school){
		School schl = schoolservice.saveSchool(school);
    return new ResponseEntity<>(schl,HttpStatus.OK);
    }
	
	@PutMapping("updateSchool")
	public ResponseEntity<School>updateSchool(@RequestBody School school){
		School schl= schoolservice.saveSchool(school);
		return new ResponseEntity<>(schl,HttpStatus.OK);
		
	}
	
	@DeleteMapping("deleteSchool/{id}")
	public ResponseEntity<School>deleteSchool(@PathVariable int id){
		     schoolservice.deleteSchool(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@GetMapping("getById/{id}")
	public ResponseEntity<School>getById(@PathVariable int id){
	School schl= schoolservice.getById(id);
		return new ResponseEntity<>(schl,HttpStatus.OK);
		
	}
	
	@GetMapping("listOfId")
	public ResponseEntity<List<School>>listOfId(@RequestParam List<Integer>id){
		List<School>schl= schoolservice.listOfId(id);
		return new ResponseEntity<>(schl,HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id, @RequestParam String name) {
        School schl= schoolservice.findSchoolByIdAndName(id, name);
		
        return new ResponseEntity<>(schl,HttpStatus.OK);
    }
	
	@GetMapping("getAll")
	public ResponseEntity<List<School>>getAll(){
	List<School>list= schoolservice.getAll();
	return new ResponseEntity<List<School>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("findByVillageIsNull")
	public ResponseEntity<List<School>>findByVillageIsNull(){
		List<School>list= schoolservice.findByVillageIsNull();
		return new ResponseEntity<List<School>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("findByVillage")
	public ResponseEntity<List<School>>findByVillage(@RequestParam String myvillage){
		List<School>list= schoolservice.findByVillage(myvillage);
		return new ResponseEntity<List<School>>(list,HttpStatus.OK);
		
	}
	
	
	@GetMapping("findByVillageList")
	public ResponseEntity<List<School>>findByVillage(@RequestParam List<String>ourvillage){
		List<School>list= schoolservice.findByVillage(ourvillage);
		return new ResponseEntity<List<School>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("getAllVillage")
	public List<String>getAllUniqueVillage(){
	return schoolservice.getAllUniqueVillage();
}
	
	@GetMapping("getAllStrength")
	public ResponseEntity<List<Integer>>getAllUniqueStrength(){
		List<Integer>list= schoolservice.getAllUniqueStrength();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("SearchFilter")
	public ResponseEntity<List<School>>findSearchFilter(@RequestParam String filterType,@RequestParam String input){
	List<School>list= schoolservice.findSearchFilter(filterType,input);
	
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("exceptions/{id}")
	  public ResponseEntity<Boolean>userDetails(@PathVariable Integer id){
		boolean result= schoolservice.existUserId(id);
		if (!result) {
			throw new IntergerToStringException();
		}
	
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
		  
	  }
	
	
	
	@GetMapping("generatePdf")
	 public ResponseEntity<byte[]>generatePdf(){
		List<School>schools = schoolservice.getAllSchools();
		PdfFile pdfFile = new PdfFile();
		 try {
			 byte [] pdfBytes= pdfFile.genFile(schools);
			 
			 HttpHeaders headers = new HttpHeaders();
		     headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=schools.pdf");
	         headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
			 
			return new ResponseEntity<>(pdfBytes,headers,HttpStatus.OK); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	
	 
	 
	 
	   @GetMapping("excel")
	    public void getExcelFile(HttpServletResponse response) throws IOException {
	        byte[] excelFile = schoolservice.generateExcelFile();
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=schools.xlsx");
	        response.getOutputStream().write(excelFile);
	    }
	
	 
	   @GetMapping("factoryDesignPattern/{type}")
	     public ResponseEntity<byte[]>factoryDesignPattern(@PathVariable String type) throws IOException{
	    	 FactoryDesignMain fds = new FactoryDesignMain(type);
	    	 byte[] fileData        = fds.genFile(schoolservice.getAll()); 	 
	    	  
	    	 
	    	  Map<String, String> map  = Map.of(
	    			 "pdf", "application/pdf",
	    			 "xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
	    			 "txt","text/plain",
	    			 "docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document"
	    			);
	    	  
	    	             String mediaType   =map.get(type);
	    	 String filename ="school."+type;
	    	 
	    	 HttpHeaders headers = new HttpHeaders();
	    	             headers.setContentType(MediaType.parseMediaType(mediaType));
	    	             headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename).build());
	    	 
	    	  return new ResponseEntity<>(fileData,headers,HttpStatus.OK);
	
	
	
	     }
	
  @GetMapping("pagination")
      public Page<School>pagination (@RequestParam Integer pagenum, @RequestParam Integer pagesize){
	       Page<School>  page =schoolservice.getPaganation(pagenum,pagesize);
	       page.getContent();
           return page;
	
}
	@GetMapping("test")
	public String test() {
		
		return "your java stop";
	}
	 
}
