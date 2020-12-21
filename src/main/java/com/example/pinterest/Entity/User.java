package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	private Long Id;

	@Column(name = "name")
	private String Name;

	@Column(name = "bio")
	private String Bio;

	@Column(name = "username")
	private String UserName;

	@Column(name = "password")
	private String PassWord;

	@Column(name = "token")
	private String Token;

	@Column(name = "image")
	private String Image;

	@Column(name = "email")
	private String Email;

	@Column(name = "phone")
	private String Phone;

	@Column(name = "country")
	private String Country;

	@Column(name = "gender")
	private boolean Gender;

	@Column(name = "age")
	private int Age;

	@Column(name = "city")
	private String City;

	public User() {
		// init class...
	}


	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}


	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String username) {
		UserName = username;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String password) {
		PassWord = password;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}

}