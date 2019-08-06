package com.apache.poi.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class CustomerDto 
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
		return "CustomerDto [firstName=" + firstName + ", lastName=" + lastName + ", Phone=" + Phone + ", Email="
				+ Email + ", Address=" + Address + "]";
	}

	public CustomerDto(@NotBlank String firstName, String lastName, @NotBlank String phone, @NotBlank String email,
			String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Phone = phone;
		Email = email;
		Address = address;
	}
	

	
	
}
