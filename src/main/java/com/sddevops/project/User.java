package com.sddevops.project;

public class User {
	protected String Name;
	protected String Password;
	protected String Date_Of_Birth;
	protected String Email;
	protected String Phone_Number;
	protected String Address;
	protected String Address2;
	protected String City;
	protected String State;
	protected String Zip;

	public User(String Name, String Password, String Date_Of_Birth, String Email, String Phone_Number, String Address,
			String Address2, String City, String State, String Zip) {
		super();
		this.Name = Name;
		this.Password = Password;
		this.Date_Of_Birth = Date_Of_Birth;
		this.Email = Email;
		this.Phone_Number = Phone_Number;
		this.Address = Address;
		this.Address2 = Address2;
		this.City = City;
		this.State = State;
		this.Zip = Zip;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getDateOfBirth() {
		return Date_Of_Birth;
	}

	public void setDateOfBirth(String Date_Of_Birth) {
		this.Date_Of_Birth = Date_Of_Birth;
	}
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPhoneNumber() {
		return Phone_Number;
	}

	public void setPhoneNumber(String Phone_Number) {
		this.Phone_Number = Phone_Number;
	}
	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String Address2) {
		this.Address2 = Address2;
	}
	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}
	public String getState() {
		return State;
	}

	public void setState(String State) {
		this.State = State;
	}
	public String getZip() {
		return Zip;
	}

	public void setZip(String Zip) {
		this.Zip = Zip;
	}
}
