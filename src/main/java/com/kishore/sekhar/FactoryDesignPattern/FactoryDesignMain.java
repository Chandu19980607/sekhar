package com.kishore.sekhar.FactoryDesignPattern;

import java.io.IOException;
import java.util.List;

import com.kishore.sekhar.model.School;



public class FactoryDesignMain {

	FileGen fileGen = null;
	 public FactoryDesignMain(String type) {
		 fileGen = FileGenSwitch.generateObject(type);
	 }
	public byte[] genFile(List<School>schl) throws IOException{
		return fileGen.genFile(schl);
	}
}











