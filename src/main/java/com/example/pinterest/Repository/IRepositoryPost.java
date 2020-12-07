package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryPost extends JpaRepository<Post,Long>
{
	//your Querys for Post
}