package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCategory extends JpaRepository<Category,Long>
{
	//your Querys for Category
}