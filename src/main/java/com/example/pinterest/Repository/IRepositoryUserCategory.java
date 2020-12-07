package com.example.pinterest.Repository;


import com.example.pinterest.Entity.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryUserCategory extends JpaRepository<UserCategory,Long>
{
	//your Querys for UserCategory
}