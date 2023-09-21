package com.fssa.healthyhair.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String username;
	private String password;
	private String number;
	private String type;
	private int userId;
	private String address;
	private String profileUrl;
	private String companyName;
	private String companyAddress;
	private String companylicense;

	public int getUserId() {
		return userId;
	}

	public User() {

	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User(String email, String username, String password, String type, String number) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
	}

	public User(String email, String username, String number, int userId) {
		super();
		this.email = email;
		this.username = username;
		this.number = number;
		this.userId = userId;

	}

	public User(String email, String username, String number, int userId, String profileUrl) {
		super();
		this.email = email;
		this.username = username;
		this.number = number;
		this.userId = userId;
		this.profileUrl = profileUrl;
	}

	public User(String email, String username, String password, String type, String number, int userId) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
		this.userId = userId;
	}

	public User(String email, String username, String password, String type, String number, int userId,
			String address) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.type = type;
		this.number = number;
		this.userId = userId;
		this.address = address;
	}

	public User(String email, String username, String number, String companyName, String companyAddress,
			String companylicense, int userId) {
		super();
		this.email = email;
		this.username = username;
		this.number = number;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companylicense = companylicense;
		this.userId = userId;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanylicense() {
		return companylicense;
	}

	public void setCompanylicense(String companylicense) {
		this.companylicense = companylicense;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", number=" + number
				+ ", type=" + type + ", userId=" + userId + ", address=" + address + "]";
	}

}
