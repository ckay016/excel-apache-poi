package com.apache.poi.Model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="customer")
public class Customer 
{
	private String firstName;
	
	private String lastName;
	
	private String Phone;

	private String Email;
	
	private String Address;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}


	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", Phone=" + Phone + ", Email=" + Email
				+ ", Address=" + Address + "]";
	}
	
	
	
	
	
}
