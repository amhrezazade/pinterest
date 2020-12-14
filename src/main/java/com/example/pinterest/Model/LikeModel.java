package com.example.pinterest.Model;

import com.example.pinterest.Entity.Like;

public class LikeModel
{
	private String Id;
	private String UserId;
	private String PostId;
	private boolean Like;

	public LikeModel (Like input)
	{
		Id = input.getId();
		UserId = input.getUserId();
		PostId = input.getPostId();
		Like = input.getIsLike();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public  String getPostId() {return PostId;}
	public void setPostId(String postid) {PostId = postid;}

	public  boolean getLike() {
		return Like;
	}
	public void setLike(boolean like) {
		Like = like;
	}

}