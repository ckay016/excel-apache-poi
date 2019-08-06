package com.apache.poi.Services.Impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import com.apache.poi.Dto.CustomerDto;
import com.apache.poi.Model.Customer;
import com.apache.poi.Repository.CustomerRepository;
import com.apache.poi.Services.CustomerServices;
import com.apache.poi.validators.ValidHeader;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerServicesImpl implements CustomerServices {
	@Autowired
	CustomerRepository cusRepo;

	@Override
	public Customer addCustomer(CustomerDto cusDto) {
		Customer cus = new Customer();
		cus.setFirstName(cusDto.getFirstName());
		cus.setLastName(cusDto.getLastName());
		cus.setEmail(cusDto.getEmail());
		cus.setPhone(cusDto.getPhone());
		cus.setAddress(cusDto.getAddress());
		System.out.println(cus);
		cusRepo.save(cus);
		return cus;
	}

	@Override
	public List<Customer> getCustomer() {
		return cusRepo.findAll();
	}

	@Override
	public String generateCustomerExcel() throws FileNotFoundException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Customer.xls");
		List<Customer> customers = cusRepo.findAll();
		int rowIndex = 1;
		for (Customer cus : customers) {
			HSSFRow row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(cus.getFirstName());
			row.createCell(1).setCellValue(cus.getLastName());
			row.createCell(2).setCellValue(cus.getEmail());
			row.createCell(3).setCellValue(cus.getPhone());
			row.createCell(4).setCellValue(cus.getAddress());
		}
		FileOutputStream file = new FileOutputStream("customerdata.xls");
		workbook.write(file);
		workbook.close();
		file.close();

		return "Generated";
	}

	@Override
	public String validateHeaders(String name) throws FileNotFoundException, IOException 
	{
		ValidHeader validHeaders = new ValidHeader();
		List<String> headers = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(name));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow headerRow = sheet.getRow(0);
		for(int i=0;i<5;i++)
			headers.add(headerRow.getCell(i).getStringCellValue());
		return validHeaders.validate(headers);
		//return null;
	}
	
}
