package com.kishore.sekhar.FactoryDesignPattern;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.kishore.sekhar.model.School;


public class WordFile implements FileGen {

	@Override
	public byte[] genFile(List<School> schl) throws IOException {
	 XWPFDocument document = new XWPFDocument();
	 XWPFTable table = document.createTable();
	 boolean isFirstTime = true;
	 for (School school:schl) {
		 XWPFTableRow row;
		 if(isFirstTime) { 
			 row = table.getRow(0);
			 isFirstTime = false;
		 }else {
			 row= table.createRow(); 
		 }
	row.createCell().setText(school.getId() +" ");
	row.createCell().setText(school.getSchoolId() +" ");
	row.createCell().setText(school.getSchoolFName() +" ");
	row.createCell().setText(school.getSchoolLName() +" ");
	row.createCell().setText(school.getFullname() +" ");
	row.createCell().setText(school.getVillage() +" ");
	row.createCell().setText(school.getStrength() +" ");
	 }
	 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	 document.write(outputStream);
	 document.close();
		 
		return outputStream.toByteArray();
	}

}









