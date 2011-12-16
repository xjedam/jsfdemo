package com.example.jsfdemo.domain;

import java.util.Calendar;
import java.util.Date;

import javax.faces.validator.FacesValidator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
	
	private String name = "unknown";
	private String email = "unknown@unkno.wn";
	private int yob = 1900;
	private String pesel ="87120108438";
	
	@Size(min=3, max=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Min(value=1900)
	public int getYob() {	
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	@Pattern(regexp="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Not a valid email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}


}
