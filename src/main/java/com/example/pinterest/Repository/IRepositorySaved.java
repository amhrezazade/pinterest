package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Saved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorySaved extends JpaRepository<Saved,Long>
{
	//your Querys for Saved
}