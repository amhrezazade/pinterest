package com.example.pinterest.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="usercategory")
public class UserCategory
{
	@Id
	@Column(name ="id")
	private String Id;

	@Column(name ="name")
	private String Name;

	@Column(name ="caption")
	private String Caption;

	public UserCategory()
	{
		//init class...
	}

	public String getId() {return Id;}
	public void setId(String id) {Id = id;}

	public String getName() {return Name;}
	public void setName(String name) {Name = name;}

	public String getCaption() {return Caption;}
	public void setCaption(String caption) {Caption = caption;}

}