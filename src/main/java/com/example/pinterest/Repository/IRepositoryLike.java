package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryLike extends JpaRepository<Like,Long>
{
	//your Querys for Like
}