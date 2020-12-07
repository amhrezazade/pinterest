package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Category;
import com.example.pinterest.Model.CategoryModel;
import com.example.pinterest.Repository.IRepositoryCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService 
{
    @Autowired
    private IRepositoryCategory CategoryRepository;

      public List<CategoryModel> getAllCategorys()
      {
        List<Category> categorys = CategoryRepository.findAll();
        ArrayList<CategoryModel> Result = new ArrayList<>();
        for (Category category:(List<Category>)categorys)
        {
            Result.add(new CategoryModel(category));
        }
        return Result;
      }
      
}