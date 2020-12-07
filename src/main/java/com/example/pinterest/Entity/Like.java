package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="like")
public class Like
{
	@Id
	@Column(name ="id")
	private String Id;

	@Column(name ="userid")
	private String UserId;

	@Column(name ="postid")
	private String PostId;

	@Column(name ="like")
	private boolean Like;

	public Like()
	{
		//init class...
	}

	public String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public String getPostId() {return PostId;}
	public void setPostId(String postid) {PostId = postid;}

	public Boolean getLike() {return Like;}
	public void setLike(boolean like) {Like = like;}

}