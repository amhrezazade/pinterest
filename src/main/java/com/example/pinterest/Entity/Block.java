package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="block")
public class Block
{
	@Id
	@Column(name ="id")
	private String Id;

	@Column(name ="userid")
	private String UserId;

	@Column(name ="followingid")
	private String FollowingId;

	public Block()
	{
		//init class...
	}

	public String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public String getFollowingId() {return FollowingId;}
	public void setFollowingId(String followingid) {FollowingId = followingid;}

}