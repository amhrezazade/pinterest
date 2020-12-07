package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryFollow extends JpaRepository<Follow,Long>
{
	//your Querys for Follow
}