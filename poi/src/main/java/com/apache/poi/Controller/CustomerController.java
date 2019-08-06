package com.apache.poi.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apache.poi.Dto.CustomerDto;
import com.apache.poi.Model.Customer;
import com.apache.poi.Services.CustomerServices;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	CustomerServices cusService;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody CustomerDto cusDto)
	{
		return cusService.addCustomer(cusDto);
	}
	
	@GetMapping("/get")
	public List<Customer> getCustomer()
	{
		return cusService.getCustomer();
	}
	
	@GetMapping("/generate")
	public String generateCustomerExcel() throws FileNotFoundException, IOException
	{
		return cusService.generateCustomerExcel();
	}
	
	@GetMapping("/validate")
	public String validateHeaders(@RequestParam(value="name") String name) throws FileNotFoundException,IOException
	{
		return cusService.validateHeaders(name);
	}
}
