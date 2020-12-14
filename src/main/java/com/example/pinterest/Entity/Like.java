package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
	@Id
	@Column(name = "id")
	private String Id;

	@Column(name = "userid")
	private String UserId;

	@Column(name = "postid")
	private String PostId;

	@Column(name = "islike")
	private boolean IsLike;

	public Like() {
		// init class...
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userid) {
		UserId = userid;
	}

	public String getPostId() {
		return PostId;
	}

	public void setPostId(String postid) {
		PostId = postid;
	}

	public boolean getIsLike() {
		return IsLike;
	}

	public void setIsLike(boolean isLike) {
		IsLike = isLike;
	}

}