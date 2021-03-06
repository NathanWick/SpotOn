package com.winbusiness.spoton;

import java.sql.Date;

public class Employee
{
	private int _id;
	private String firstName;
	private String lastName;
	private int phone1;
	private int phone2;
	private String emailAdress;
	private String homeAdress;
	private String hireDate;
	private String terminationDate;
	private double defaultRate;
	private int accessCode;
	
	public Employee(String firstName, String lastName, int phone1, int phone2, String emailAdress, String homeAdress, String hireDate, String terminationDate, double defaultRate, int accessCode) 
	{
		this.firstName = firstName != null ? firstName : "";
		this.lastName = lastName != null ? lastName : "";
		this.phone1 = phone1 != 0 ? phone1 : 0;
		this.phone2 = phone2 != 0 ? phone2 : 0;
		this.emailAdress = emailAdress != null ? emailAdress : "";
		this.homeAdress = homeAdress != null ? homeAdress : "";
		this.hireDate = hireDate != null ? hireDate : "";
		this.terminationDate = terminationDate != null ? terminationDate : "";
		this.defaultRate = defaultRate != 0.0 ? defaultRate : 0.0;
		this.accessCode = accessCode != 0 ? accessCode : 0;
	}
	
	public Employee(String firstName, String lastName, int accessCode) 
	{
		this.firstName = firstName != null ? firstName : "";
		this.lastName = lastName != null ? lastName : "";
		phone1 = 0;
		phone2 = 0;
		emailAdress = "";
		homeAdress = "";
		hireDate = null;
		terminationDate = null;
		defaultRate = 0;
		this.accessCode = accessCode != 0 ? accessCode : 0;
	}

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

	public int getPhone1() {
		return phone1;
	}

	public void setPhone1(int phone1) {
		this.phone1 = phone1;
	}

	public int getPhone2() {
		return phone2;
	}

	public void setPhone2(int phone2) {
		this.phone2 = phone2;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}

	public double getDefaultRate() {
		return defaultRate;
	}

	public void setDefaultRate(double defaultRate) {
		this.defaultRate = defaultRate;
	}

	public int getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(int accessCode) {
		this.accessCode = accessCode;
	}
	
	public int getId()
	{
		return _id;
	}
	
}
