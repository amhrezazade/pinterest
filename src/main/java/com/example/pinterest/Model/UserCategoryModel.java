package com.example.pinterest.Model;

import com.example.pinterest.Entity.UserCategory;

public class UserCategoryModel
{
	private String Id;
	private String Name;
	private String Caption;

	public UserCategoryModel (UserCategory input)
	{
		Id = input.getId();
		Name = input.getName();
		Caption = input.getCaption();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getName() {return Name;}
	public void setName(String name) {Name = name;}

	public  String getCaption() {return Caption;}
	public void setCaption(String caption) {Caption = caption;}

}