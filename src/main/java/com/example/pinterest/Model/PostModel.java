package com.example.pinterest.Model;

import com.example.pinterest.Entity.Post;
public class PostModel
{
	private String Id;
	private String UserId;
	private String Image;
	private String Caption;
	private String CategoryId;

	public PostModel (Post input)
	{
		Id = input.getId();
		UserId = input.getUserId();
		Image = input.getImage();
		Caption = input.getCaption();
		CategoryId = input.getCategoryId();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public  String getImage() {return Image;}
	public void setImage(String image) {Image = image;}

	public  String getCaption() {return Caption;}
	public void setCaption(String caption) {Caption = caption;}

	public  String getCategoryId() {return CategoryId;}
	public void setCategoryId(String categoryid) {CategoryId = categoryid;}

}