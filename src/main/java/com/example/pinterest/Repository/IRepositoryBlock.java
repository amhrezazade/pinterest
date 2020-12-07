package com.example.pinterest.Repository;


import com.example.pinterest.Entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBlock extends JpaRepository<Block, Long>
{
	//your Querys for Block
}