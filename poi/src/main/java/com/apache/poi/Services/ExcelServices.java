package com.apache.poi.Services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExcelServices 
{
	public String validateExcel(String name) throws IOException,FileNotFoundException;

	String generateForm(String js) throws IOException;
}
