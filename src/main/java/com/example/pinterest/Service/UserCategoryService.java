package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.UserCategory;
import com.example.pinterest.Model.UserCategoryModel;
import com.example.pinterest.Repository.IRepositoryUserCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryService 
{
    @Autowired
    private IRepositoryUserCategory UserCategoryRepository;

      public List<UserCategoryModel> getAllUserCategorys()
      {
        List<UserCategory> usercategorys = UserCategoryRepository.findAll();
        ArrayList<UserCategoryModel> Result = new ArrayList<>();
        for (UserCategory usercategory:(List<UserCategory>)usercategorys)
        {
            Result.add(new UserCategoryModel(usercategory));
        }
        return Result;
      }
      
}