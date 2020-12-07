package com.example.pinterest.Model;

import com.example.pinterest.Entity.Category;

public class CategoryModel
{
	private String Id;
	private String UserId;
	private String Caption;

	public CategoryModel (Category input)
	{
		Id = input.getId();
		UserId = input.getUserId();
		Caption = input.getCaption();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public  String getCaption() {return Caption;}
	public void setCaption(String caption) {Caption = caption;}

}