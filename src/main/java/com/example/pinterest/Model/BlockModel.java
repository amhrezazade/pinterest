package com.example.pinterest.Model;


import com.example.pinterest.Entity.Block;

public class BlockModel
{
	private String Id;
	private String UserId;
	private String FollowingId;

	public BlockModel (Block input)
	{
		Id = input.getId();
		UserId = input.getUserId();
		FollowingId = input.getFollowingId();
	}

	public  String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public  String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public  String getFollowingId() {return FollowingId;}
	public void setFollowingId(String followingid) {FollowingId = followingid;}

}