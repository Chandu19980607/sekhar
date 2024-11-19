package com.kishore.sekhar.FactoryDesignPattern;

import java.io.IOException;
import java.util.List;

import com.kishore.sekhar.model.School;



public interface FileGen {
	public abstract byte[] genFile(List<School>schl)throws IOException;

}
