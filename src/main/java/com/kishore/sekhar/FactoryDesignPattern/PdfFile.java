package com.kishore.sekhar.FactoryDesignPattern;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.kishore.sekhar.model.School;


public class PdfFile implements FileGen {

	@Override
	public byte[] genFile(List<School> schl) throws IOException {
       Document pdfDocument = new Document();
       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
       try {
    	   PdfWriter.getInstance(pdfDocument, outputStream);
    	   pdfDocument.open();
    	   
    	   for(School school:schl) {
    		   Paragraph ph= new Paragraph(school.getId() + "  " +school.getFullname()+ "  " +school.getStrength()+"  " +school.getVillage() +" "+school.getSchoolId());
    	       pdfDocument.add(ph);
    	   
    	   }
	}
    	   catch (DocumentException e) {
		        e.printStackTrace();
	}
    	   finally {
    		   pdfDocument.close();
    	   }
            
		return outputStream.toByteArray();
	
	}

}










