package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="post")
public class Post
{
	@Id
	@Column(name ="id")
	private String Id;

	@Column(name ="userid")
	private String UserId;

	@Column(name ="image")
	private String Image;

	@Column(name ="caption")
	private String Caption;

	@Column(name ="categoryid")
	private String CategoryId;

	public Post()
	{
		//init class...
	}

	public String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public String getUserId() {return UserId;}
	public void setUserId(String userid) {UserId = userid;}

	public String getImage() {return Image;}
	public void setImage(String image) {Image = image;}

	public String getCaption() {return Caption;}
	public void setCaption(String caption) {Caption = caption;}

	public String getCategoryId() {return CategoryId;}
	public void setCategoryId(String categoryid) {CategoryId = categoryid;}

}