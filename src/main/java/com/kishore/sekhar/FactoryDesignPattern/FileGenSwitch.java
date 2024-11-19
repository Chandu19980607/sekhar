package com.kishore.sekhar.FactoryDesignPattern;


public class FileGenSwitch {

	public static FileGen generateObject(String file) {
		FileGen fileType= null;
		switch (file) {
		case "pdf":
			fileType= new PdfFile();
			break;
		case "docx":
			fileType = new WordFile();
			break;
		case "txt":
			fileType= new TextFile();
			break;
		case "xlsx":
			fileType= new ExcelFile();
			break;
		default:
			break;
		}
		return fileType;
	}
}












