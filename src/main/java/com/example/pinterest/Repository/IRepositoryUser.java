package com.example.pinterest.Repository;


import com.example.pinterest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User,Long>
{
	//your Querys for User
}