package com.example.pinterest.Model;

import com.example.pinterest.Entity.Saved;


public class SavedModel
{
	private String Id;
	private String UserId;
	private String PostId;

	public SavedModel (Saved input)
	{
		Id = input.getId();
		UserId = input.getUserId();
		PostId = input.getPostId();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public  String getPostId() {return PostId;}
	public void setPostId(String postid) {PostId = postid;}

}