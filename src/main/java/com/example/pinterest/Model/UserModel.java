package com.example.pinterest.Model;

import com.example.pinterest.Entity.User;

public class UserModel
{
	private String Id;
	private String UserName;
	private String Image;
	private String Email;
	private String Phone;
	private boolean Gender;
	private String Address;

	public UserModel (User input)
	{
		Id = input.getId();
		UserName = input.getUserName();
		Image = input.getImage();
		Email = input.getEmail();
		Phone = input.getPhone();
		Gender = input.getGender();
		Address = input.getAddress();
	}
 public UserModel ()
 {

 }


	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserName() {return UserName;}
	public void setUserName(String username) {UserName = username;}

	public  String getImage() {return Image;}
	public void setImage(String image) {Image = image;}

	public  String getEmail() {return Email;}
	public void setEmail(String email) {Email = email;}

	public  String getPhone() {return Phone;}
	public void setPhone(String phone) {Phone = phone;}

	public  boolean getGender() {
		return Gender;
	}
	public void setGender(boolean gender) {Gender = gender;}

	public  String getAddress() {return Address;}
	public void setAddress(String address) {Address = address;}


}