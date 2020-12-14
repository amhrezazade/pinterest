package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user")
public class User
{
	@Id
	@Column(name ="id")
	private String Id;

	@Column(name ="username")
	private String UserName;

	@Column(name ="password")
	private String PassWord;

	@Column(name ="token")
	private String Token;

	@Column(name ="image")
	private String Image;

	@Column(name ="email")
	private String Email;

	@Column(name ="phone")
	private String Phone;

	@Column(name ="country")
	private String Country;

	@Column(name ="gender")
	private boolean Gender;

	@Column(name ="address")
	private String Address;

	public User()
	{
		//init class...
	}

	public String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public String getUserName() {return UserName;}
	public void setUserName(String username) {UserName = username;}

	public String getPassWord() {return PassWord;}
	public void setPassWord(String password) {PassWord = password;}

	public String getToken() {return Token;}
	public void setToken(String token) {Token = token;}

	public String getImage() {return Image;}
	public void setImage(String image) {Image = image;}

	public String getEmail() {return Email;}
	public void setEmail(String email) {Email = email;}

	public String getPhone() {return Phone;}
	public void setPhone(String phone) {Phone = phone;}

	public String getCountry() {return Country;}
	public void setCountry(String country) {Country = country;}

	public boolean getGender() {return Gender;}
	public void setGender(Boolean gender) {Gender = gender;}

	public String getAddress() {return Address;}
	public void setAddress(String address) {Address = address;}

}