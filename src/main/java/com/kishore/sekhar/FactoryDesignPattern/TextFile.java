package com.kishore.sekhar.FactoryDesignPattern;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.kishore.sekhar.model.School;


public class TextFile implements FileGen {

	@Override
	public byte[] genFile(List<School> schl) throws IOException {
		ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
		
		try	(OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
				for (School school:schl) {
				writer.write(school.getId() +" "+ school.getSchoolId() +" " + school.getSchoolFName() +" "+ school.getSchoolLName() +" " + school.getFullname() +" "+school.getVillage() +"  " + school.getStrength()+ "\n");
				}
				
		} 
		
		return outputStream.toByteArray();
	
	}
}







