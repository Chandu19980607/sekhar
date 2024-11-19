package com.kishore.sekhar.FactoryDesignPattern;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.kishore.sekhar.model.School;


@Component
public class ExcelFile implements FileGen{

	@Override
	public byte[] genFile(List<School> schl) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("School Details");
		XSSFRow row;
		row= sheet.createRow(0);
		row.createCell(0).setCellValue("id");	
		row.createCell(1).setCellValue("School_id");
		row.createCell(2).setCellValue("Strength");
		row.createCell(3).setCellValue("Village");
		row.createCell(4).setCellValue("Fullname");
		row.createCell(5).setCellValue("SchoolFname");
		row.createCell(6).setCellValue("SchoolLname");
		row.createCell(7).setCellValue("Name");
		int rowcount=1;
		
		for(School person:schl) {
		row= sheet.createRow(rowcount);
		row.createCell(0).setCellValue(person.getId());
		row.createCell(1).setCellValue(person.getSchoolId());
		row.createCell(2).setCellValue(person.getStrength());
		row.createCell(3).setCellValue(person.getVillage());
		row.createCell(4).setCellValue(person.getFullname());
		row.createCell(5).setCellValue(person.getSchoolFName());
		row.createCell(6).setCellValue(person.getSchoolLName());
		row.createCell(7).setCellValue(person.getName());
		rowcount++;
		}	
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return outputStream.toByteArray();
		
		
	}
		
	}










